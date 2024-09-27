/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.impl.base.test

import com.intellij.openapi.util.io.FileUtil
import org.jetbrains.kotlin.analysis.api.KaSession
import org.jetbrains.kotlin.analysis.api.impl.base.test.SymbolByFqName.getSymbolDataFromFile
import org.jetbrains.kotlin.analysis.api.impl.base.test.SymbolData.TypeParameterData
import org.jetbrains.kotlin.analysis.api.symbols.KaCallableSymbol
import org.jetbrains.kotlin.analysis.api.symbols.KaClassKind
import org.jetbrains.kotlin.analysis.api.symbols.KaClassSymbol
import org.jetbrains.kotlin.analysis.api.symbols.KaDeclarationSymbol
import org.jetbrains.kotlin.analysis.api.symbols.KaNamedClassSymbol
import org.jetbrains.kotlin.analysis.api.symbols.KaSymbol
import org.jetbrains.kotlin.analysis.api.symbols.typeParameters
import org.jetbrains.kotlin.analysis.utils.errors.requireIsInstance
import org.jetbrains.kotlin.name.CallableId
import org.jetbrains.kotlin.name.ClassId
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.psi.KtFile
import java.io.File
import java.nio.file.Path

object SymbolByFqName {
    fun getSymbolDataFromFile(filePath: Path): SymbolData {
        val testFileText = FileUtil.loadFile(filePath.toFile())
        val identifier = testFileText.lineSequence().first { line ->
            SymbolData.identifiers.any { identifier ->
                line.startsWith(identifier) || line.startsWith("// $identifier")
            }
        }
        return SymbolData.create(identifier.removePrefix("// "))
    }

    fun textWithRenderedSymbolData(filePath: String, rendered: String): String = buildString {
        val testFileText = FileUtil.loadFile(File(filePath))
        val fileTextWithoutSymbolsData = testFileText.substringBeforeLast(SYMBOLS_TAG).trimEnd()
        appendLine(fileTextWithoutSymbolsData)
        appendLine()
        appendLine(SYMBOLS_TAG)
        append(rendered)
    }

    private const val SYMBOLS_TAG = "// SYMBOLS:"
}

inline fun <reified S : KaSymbol> KaSession.getSingleTestTargetSymbolOfType(mainFile: KtFile, testDataPath: Path): S {
    val symbols = with(getSymbolDataFromFile(testDataPath)) { toSymbols(mainFile) }
    return symbols.singleOrNull() as? S
        ?: error("Expected a single target `${S::class.simpleName}` to be specified, but found the following symbols: $symbols")
}

sealed class SymbolData {
    abstract fun KaSession.toSymbols(ktFile: KtFile): List<KaSymbol>

    data class PackageData(val packageFqName: FqName) : SymbolData() {
        override fun KaSession.toSymbols(ktFile: KtFile): List<KaSymbol> {
            val symbol = findPackage(packageFqName) ?: error("Cannot find a symbol for the package `$packageFqName`.")
            return listOf(symbol)
        }
    }

    data class ClassData(val classId: ClassId) : SymbolData() {
        override fun KaSession.toSymbols(ktFile: KtFile): List<KaSymbol> {
            val symbol = findClass(classId) ?: error("Class $classId is not found")
            return listOf(symbol)
        }
    }

    object ScriptData : SymbolData() {
        override fun KaSession.toSymbols(ktFile: KtFile): List<KaSymbol> {
            val script = ktFile.script ?: error("Script is not found")
            return listOf(script.symbol)
        }
    }

    data class TypeAliasData(val classId: ClassId) : SymbolData() {
        override fun KaSession.toSymbols(ktFile: KtFile): List<KaSymbol> {
            val symbol = findTypeAlias(classId) ?: error("Type alias $classId is not found")
            return listOf(symbol)
        }
    }

    data class CallableData(val callableId: CallableId) : SymbolData() {
        override fun KaSession.toSymbols(ktFile: KtFile): List<KaSymbol> {
            val classId = callableId.classId

            val symbols = if (classId == null) {
                findTopLevelCallables(callableId.packageName, callableId.callableName).toList()
            } else {
                val classSymbol = findClass(classId) ?: error("Class $classId is not found")
                findMatchingCallableSymbols(classSymbol)
            }

            if (symbols.isEmpty()) {
                error("No callable with fqName $callableId found")
            }

            return symbols
        }

        private fun KaSession.findMatchingCallableSymbols(classSymbol: KaClassSymbol): List<KaCallableSymbol> {
            val declaredSymbols = classSymbol.combinedDeclaredMemberScope
                .callables(callableId.callableName).toList()

            if (declaredSymbols.isNotEmpty()) {
                return declaredSymbols
            }

            // Fake overrides are absent in the declared member scope
            return classSymbol.combinedMemberScope
                .callables(callableId.callableName)
                .filter { it.containingDeclaration == classSymbol }
                .toList()
        }
    }

    data class EnumEntryInitializerData(val enumEntryId: CallableId) : SymbolData() {
        override fun KaSession.toSymbols(ktFile: KtFile): List<KaSymbol> {
            val classSymbol = enumEntryId.classId?.let { findClass(it) }
                ?: error("Cannot find enum class `${enumEntryId.classId}`.")

            require(classSymbol is KaNamedClassSymbol) { "`${enumEntryId.classId}` must be a named class." }
            require(classSymbol.classKind == KaClassKind.ENUM_CLASS) { "`${enumEntryId.classId}` must be an enum class." }

            @Suppress("DEPRECATION")
            val enumEntrySymbol = classSymbol.enumEntries.find { it.name == enumEntryId.callableName }
                ?: error("Cannot find enum entry symbol `$enumEntryId`.")

            val initializerSymbol = enumEntrySymbol.enumEntryInitializer ?: error("`${enumEntryId.callableName}` must have an initializer.")
            return listOf(initializerSymbol)
        }
    }

    data class SamConstructorData(val classId: ClassId) : SymbolData() {
        override fun KaSession.toSymbols(ktFile: KtFile): List<KaSymbol> {
            val symbol = findClass(classId)
                ?: findTypeAlias(classId)
                ?: error("Class-like symbol is not found by '$classId'")

            val samConstructor = symbol.samConstructor ?: error("SAM constructor is not found for symbol '$symbol'")
            return listOf(samConstructor)
        }
    }

    data class TypeParameterData(val name: Name, val ownerData: SymbolData): SymbolData() {
        override fun KaSession.toSymbols(ktFile: KtFile): List<KaSymbol> {
            val owner = with(ownerData) { toSymbols(ktFile) }.singleOrNull() ?: error("No owner found")
            requireIsInstance<KaDeclarationSymbol>(owner)
            val parameterSymbol = owner.typeParameters.find { it.name == name }
                ?: error("Type parameter with '$name' name is not found in $ownerData")

            return listOf(parameterSymbol)
        }
    }

    companion object {
        val identifiers = arrayOf(
            "package:",
            "callable:",
            "class:",
            "typealias:",
            "enum_entry_initializer:",
            "script",
            "sam_constructor:",
            "type_parameter:",
        )

        fun create(data: String): SymbolData {
            val key = data.substringBefore(":")
            val value = data.substringAfter(":").trim()
            return when (key) {
                "script" -> ScriptData
                "package" -> PackageData(extractPackageFqName(value))
                "class" -> ClassData(ClassId.fromString(value))
                "typealias" -> TypeAliasData(ClassId.fromString(value))
                "callable" -> CallableData(extractCallableId(value))
                "enum_entry_initializer" -> EnumEntryInitializerData(extractCallableId(value))
                "sam_constructor" -> SamConstructorData(ClassId.fromString(value))
                "type_parameter" -> extractTypeParameterData(value)
                else -> error("Invalid symbol kind, expected one of: $identifiers")
            }
        }
    }
}

private fun extractTypeParameterData(data: String): TypeParameterData {
    val typeParameterName = data.substringBefore(":")
    val owner = data.substringAfter(":").trim()
    val ownerData = SymbolData.create(owner)
    return TypeParameterData(Name.identifier(typeParameterName), ownerData)
}

private fun extractPackageFqName(data: String): FqName = FqName.fromSegments(data.split('.'))

private fun extractCallableId(fullName: String): CallableId {
    val name = if ('.' in fullName) fullName.substringAfterLast(".") else fullName.substringAfterLast('/')
    val (packageName, className) = run {
        val packageNameWithClassName = fullName.dropLast(name.length + 1)
        when {
            '.' in fullName ->
                packageNameWithClassName.substringBeforeLast('/') to packageNameWithClassName.substringAfterLast('/')
            else -> packageNameWithClassName to null
        }
    }
    return CallableId(FqName(packageName.replace('/', '.')), className?.let { FqName(it) }, Name.identifier(name))
}
