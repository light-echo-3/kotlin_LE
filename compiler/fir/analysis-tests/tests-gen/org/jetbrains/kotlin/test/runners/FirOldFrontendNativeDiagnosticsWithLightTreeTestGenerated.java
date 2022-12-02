/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.test.runners;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.test.generators.GenerateCompilerTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/diagnostics/nativeTests")
@TestDataPath("$PROJECT_ROOT")
public class FirOldFrontendNativeDiagnosticsWithLightTreeTestGenerated extends AbstractFirNativeDiagnosticsWithLightTreeTest {
    @Test
    public void testAllFilesPresentInNativeTests() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/diagnostics/nativeTests"), Pattern.compile("^(.+)\\.kt$"), Pattern.compile("^(.+)\\.(fir|ll)\\.kts?$"), true);
    }

    @Test
    @TestMetadata("identifiers.kt")
    public void testIdentifiers() throws Exception {
        runTest("compiler/testData/diagnostics/nativeTests/identifiers.kt");
    }

    @Test
    @TestMetadata("isInitialized.kt")
    public void testIsInitialized() throws Exception {
        runTest("compiler/testData/diagnostics/nativeTests/isInitialized.kt");
    }

    @Test
    @TestMetadata("isInitializedError.kt")
    public void testIsInitializedError() throws Exception {
        runTest("compiler/testData/diagnostics/nativeTests/isInitializedError.kt");
    }

    @Test
    @TestMetadata("objCName.kt")
    public void testObjCName() throws Exception {
        runTest("compiler/testData/diagnostics/nativeTests/objCName.kt");
    }

    @Test
    @TestMetadata("objCRefinement.kt")
    public void testObjCRefinement() throws Exception {
        runTest("compiler/testData/diagnostics/nativeTests/objCRefinement.kt");
    }

    @Test
    @TestMetadata("sharedImmutable.kt")
    public void testSharedImmutable() throws Exception {
        runTest("compiler/testData/diagnostics/nativeTests/sharedImmutable.kt");
    }

    @Test
    @TestMetadata("threadLocal.kt")
    public void testThreadLocal() throws Exception {
        runTest("compiler/testData/diagnostics/nativeTests/threadLocal.kt");
    }

    @Test
    @TestMetadata("throws.kt")
    public void testThrows() throws Exception {
        runTest("compiler/testData/diagnostics/nativeTests/throws.kt");
    }

    @Test
    @TestMetadata("throwsClash.kt")
    public void testThrowsClash() throws Exception {
        runTest("compiler/testData/diagnostics/nativeTests/throwsClash.kt");
    }

    @Test
    @TestMetadata("topLevelSingleton.kt")
    public void testTopLevelSingleton() throws Exception {
        runTest("compiler/testData/diagnostics/nativeTests/topLevelSingleton.kt");
    }
}
