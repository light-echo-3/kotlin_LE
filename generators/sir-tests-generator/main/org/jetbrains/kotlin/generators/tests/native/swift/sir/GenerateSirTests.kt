/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.generators.tests.native.swift.sir

import org.jetbrains.kotlin.generators.generateTestGroupSuiteWithJUnit5
import org.jetbrains.kotlin.generators.tests.frontendFir
import org.jetbrains.kotlin.generators.tests.provider
import org.jetbrains.kotlin.swiftexport.standalone.AbstractSwiftExportExecutionTest
import org.jetbrains.kotlin.konan.test.blackbox.support.group.UseStandardTestCaseGroupProvider
import org.jetbrains.kotlin.sir.bridge.AbstractKotlinSirBridgeTest
import org.jetbrains.kotlin.swiftexport.standalone.AbstractKlibBasedSwiftRunnerTest


fun main() {
    System.setProperty("java.awt.headless", "true")
    generateTestGroupSuiteWithJUnit5 {
        testGroup(
            "native/swift/sir-compiler-bridge/tests-gen/",
            "native/swift/sir-compiler-bridge/testData"
        ) {
            testClass<AbstractKotlinSirBridgeTest>(
                suiteTestClassName = "SirCompilerBridgeTestGenerated"
            ) {
                model("", extension = null, recursive = false)
            }
        }
        testGroup(
            "native/swift/swift-export-standalone/tests-gen/",
            "native/swift/swift-export-standalone/testData/generation"
        ) {
            testClass<AbstractKlibBasedSwiftRunnerTest>(
                suiteTestClassName = "KlibBasedSwiftExportRunnerTest",
                annotations = listOf(
                    *frontendFir(),
                    provider<UseStandardTestCaseGroupProvider>(),
                ),
            ) {
                model("", extension = null, recursive = false)
            }
        }
        // Swift Export
        testGroup(
            "native/swift/swift-export-standalone/tests-gen/",
            "native/swift/swift-export-standalone/testData/execution"
        ) {
            testClass<AbstractSwiftExportExecutionTest>(
                suiteTestClassName = "SwiftExportExecutionTestGenerated",
                annotations = listOf(
                    *frontendFir(),
                    provider<UseStandardTestCaseGroupProvider>(),
                ),
            ) {
                model(pattern = "^([^_](.+))$", recursive = false)
            }
        }
    }
}
