/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.sir.lightclasses

import org.jetbrains.kotlin.analysis.api.projectStructure.KaModule
import org.jetbrains.kotlin.analysis.api.symbols.*
import org.jetbrains.kotlin.sir.SirDeclaration
import org.jetbrains.kotlin.sir.providers.SirDeclarationProvider
import org.jetbrains.kotlin.sir.providers.SirSession
import org.jetbrains.sir.lightclasses.nodes.*

public class SirDeclarationFromKtSymbolProvider(
    private val ktModule: KaModule,
    private val sirSession: SirSession,
) : SirDeclarationProvider {

    override fun KaDeclarationSymbol.sirDeclaration(): SirDeclaration {
        return when (val ktSymbol = this@sirDeclaration) {
            is KaNamedClassSymbol -> {
                SirClassFromKtSymbol(
                    ktSymbol = ktSymbol,
                    ktModule = ktModule,
                    sirSession = sirSession,
                )
            }
            is KaConstructorSymbol -> {
                SirInitFromKtSymbol(
                    ktSymbol = ktSymbol,
                    ktModule = ktModule,
                    sirSession = sirSession,
                )
            }
            is KaFunctionSymbol -> {
                SirFunctionFromKtSymbol(
                    ktSymbol = ktSymbol,
                    ktModule = ktModule,
                    sirSession = sirSession,
                )
            }
            is KaVariableSymbol -> {
                SirVariableFromKtSymbol(
                    ktSymbol = ktSymbol,
                    ktModule = ktModule,
                    sirSession = sirSession,
                )
            }
            is KaTypeAliasSymbol -> {
                SirTypealiasFromKtSymbol(
                    ktSymbol = ktSymbol,
                    ktModule = ktModule,
                    sirSession = sirSession,
                )
            }
            else -> TODO("encountered unknown symbol type - $ktSymbol. Error system should be reworked KT-65980")
        }
    }
}
