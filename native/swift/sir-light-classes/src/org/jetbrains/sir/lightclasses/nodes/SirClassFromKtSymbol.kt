/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.sir.lightclasses.nodes

import org.jetbrains.kotlin.analysis.api.components.DefaultTypeClassIds
import org.jetbrains.kotlin.analysis.api.projectStructure.KaModule
import org.jetbrains.kotlin.analysis.api.symbols.KaClassKind
import org.jetbrains.kotlin.analysis.api.symbols.KaClassSymbol
import org.jetbrains.kotlin.analysis.api.symbols.KaNamedClassSymbol
import org.jetbrains.kotlin.analysis.api.symbols.KaSymbolModality
import org.jetbrains.kotlin.analysis.api.types.symbol
import org.jetbrains.kotlin.sir.*
import org.jetbrains.kotlin.sir.builder.buildGetter
import org.jetbrains.kotlin.sir.builder.buildInit
import org.jetbrains.kotlin.sir.builder.buildVariable
import org.jetbrains.kotlin.sir.providers.SirSession
import org.jetbrains.kotlin.sir.providers.source.KotlinSource
import org.jetbrains.kotlin.sir.providers.utils.KotlinRuntimeModule
import org.jetbrains.kotlin.sir.providers.utils.computeIsOverrideForDesignatedInit
import org.jetbrains.kotlin.sir.providers.utils.containingModule
import org.jetbrains.kotlin.sir.providers.utils.updateImport
import org.jetbrains.kotlin.sir.util.SirSwiftModule
import org.jetbrains.sir.lightclasses.SirFromKtSymbol
import org.jetbrains.sir.lightclasses.extensions.documentation
import org.jetbrains.sir.lightclasses.extensions.lazyWithSessions
import org.jetbrains.sir.lightclasses.extensions.withSessions

internal class SirClassFromKtSymbol(
    override val ktSymbol: KaNamedClassSymbol,
    override val ktModule: KaModule,
    override val sirSession: SirSession,
) : SirClass(), SirFromKtSymbol<KaNamedClassSymbol> {

    override val origin: SirOrigin by lazy {
        KotlinSource(ktSymbol)
    }
    override val visibility: SirVisibility by lazy {
        SirVisibility.PUBLIC
    }
    override val modality: SirModality by lazy {
        when (ktSymbol.modality) {
            KaSymbolModality.OPEN -> SirModality.OPEN
            KaSymbolModality.FINAL -> SirModality.FINAL
            KaSymbolModality.SEALED, KaSymbolModality.ABSTRACT -> SirModality.UNSPECIFIED
        }
    }

    override val documentation: String? by lazy {
        ktSymbol.documentation()
    }
    override val name: String by lazy {
        ktSymbol.name.asString()
    }

    override var parent: SirDeclarationParent
        get() = withSessions {
            ktSymbol.getSirParent(useSiteSession)
        }
        set(_) = Unit

    override val declarations: List<SirDeclaration> by lazyWithSessions {
        childDeclarations() + syntheticDeclarations()
    }

    override val superClass: SirType? by lazyWithSessions {
        ktSymbol.superTypes
            .mapNotNull { it.symbol as? KaClassSymbol }
            .firstOrNull { it.classKind == KaClassKind.CLASS }
            ?.let {
                if (it.classId == DefaultTypeClassIds.ANY) {
                    SirNominalType(KotlinRuntimeModule.kotlinBase).also {
                        ktSymbol.containingModule.sirModule().updateImport(SirImport(KotlinRuntimeModule.name))
                    }
                } else {
                    (it.sirDeclaration() as? SirNamedDeclaration)
                        ?.also { ktSymbol.containingModule.sirModule().updateImport(SirImport(it.containingModule().name)) }
                        ?.let { SirNominalType(it) }
                }
            }
    }

    override val attributes: MutableList<SirAttribute> = mutableListOf()

    private fun childDeclarations(): List<SirDeclaration> = withSessions {
        ktSymbol.combinedDeclaredMemberScope
            .extractDeclarations(useSiteSession)
            .toList()
    }

    private fun kotlinBaseInitDeclaration(): SirDeclaration = buildInit {
        origin = SirOrigin.KotlinBaseInitOverride(`for` = KotlinSource(ktSymbol))
        isFailable = false
        initKind = SirInitializerKind.ORDINARY
        isOverride = true
        parameters.add(
            SirParameter(
                argumentName = "__externalRCRef",
                type = SirNominalType(SirSwiftModule.uint)
            )
        )
    }.also { it.parent = this }

    private fun syntheticDeclarations(): List<SirDeclaration> = when (ktSymbol.classKind) {
        KaClassKind.OBJECT, KaClassKind.COMPANION_OBJECT -> listOf(
            kotlinBaseInitDeclaration(),
            buildInit {
                origin = SirOrigin.PrivateObjectInit(`for` = KotlinSource(ktSymbol))
                visibility = SirVisibility.PRIVATE
                isFailable = false
                initKind = SirInitializerKind.ORDINARY
                isOverride = computeIsOverrideForDesignatedInit(this@SirClassFromKtSymbol, emptyList())
            },
            buildVariable {
                origin = SirOrigin.ObjectAccessor(`for` = KotlinSource(ktSymbol))
                visibility = SirVisibility.PUBLIC
                type = SirNominalType(this@SirClassFromKtSymbol)
                name = "shared"
                isInstance = false
                modality = SirModality.FINAL
                getter = buildGetter {}
            }.also {
                it.getter.parent = it
            }
        ).onEach { it.parent = this }

        else -> listOf(kotlinBaseInitDeclaration())
    }
}
