/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.standalone.fir.test.cases.generated.cases.components.resolver;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.analysis.api.standalone.fir.test.configurators.AnalysisApiFirStandaloneModeTestConfiguratorFactory;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfiguratorFactoryData;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfigurator;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.TestModuleKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.FrontendKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisSessionMode;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiMode;
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.resolver.AbstractResolveReferenceWithResolveExtensionTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/resolveExtensions/referenceResolve")
@TestDataPath("$PROJECT_ROOT")
public class FirStandaloneNormalAnalysisSourceModuleResolveReferenceWithResolveExtensionTestGenerated extends AbstractResolveReferenceWithResolveExtensionTest {
  @NotNull
  @Override
  public AnalysisApiTestConfigurator getConfigurator() {
    return AnalysisApiFirStandaloneModeTestConfiguratorFactory.INSTANCE.createConfigurator(
      new AnalysisApiTestConfiguratorFactoryData(
        FrontendKind.Fir,
        TestModuleKind.Source,
        AnalysisSessionMode.Normal,
        AnalysisApiMode.Standalone
      )
    );
  }

  @Test
  public void testAllFilesPresentInReferenceResolve() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/resolveExtensions/referenceResolve"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/resolveExtensions/referenceResolve/multiModule")
  @TestDataPath("$PROJECT_ROOT")
  public class MultiModule {
    @Test
    public void testAllFilesPresentInMultiModule() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/resolveExtensions/referenceResolve/multiModule"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Nested
    @TestMetadata("analysis/analysis-api/testData/resolveExtensions/referenceResolve/multiModule/extendedModuleDependency")
    @TestDataPath("$PROJECT_ROOT")
    public class ExtendedModuleDependency {
      @Test
      public void testAllFilesPresentInExtendedModuleDependency() {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/resolveExtensions/referenceResolve/multiModule/extendedModuleDependency"), Pattern.compile("^(.+)\\.kt$"), null, true);
      }

      @Test
      @TestMetadata("classMember.kt")
      public void testClassMember() {
        runTest("analysis/analysis-api/testData/resolveExtensions/referenceResolve/multiModule/extendedModuleDependency/classMember.kt");
      }

      @Test
      @TestMetadata("extensionFunction.kt")
      public void testExtensionFunction() {
        runTest("analysis/analysis-api/testData/resolveExtensions/referenceResolve/multiModule/extendedModuleDependency/extensionFunction.kt");
      }

      @Test
      @TestMetadata("shadowedDeclaration.kt")
      public void testShadowedDeclaration() {
        runTest("analysis/analysis-api/testData/resolveExtensions/referenceResolve/multiModule/extendedModuleDependency/shadowedDeclaration.kt");
      }

      @Test
      @TestMetadata("shadowedJava.kt")
      public void testShadowedJava() {
        runTest("analysis/analysis-api/testData/resolveExtensions/referenceResolve/multiModule/extendedModuleDependency/shadowedJava.kt");
      }

      @Test
      @TestMetadata("shadowedOverload.kt")
      public void testShadowedOverload() {
        runTest("analysis/analysis-api/testData/resolveExtensions/referenceResolve/multiModule/extendedModuleDependency/shadowedOverload.kt");
      }

      @Test
      @TestMetadata("topLevelFunction.kt")
      public void testTopLevelFunction() {
        runTest("analysis/analysis-api/testData/resolveExtensions/referenceResolve/multiModule/extendedModuleDependency/topLevelFunction.kt");
      }
    }
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/resolveExtensions/referenceResolve/singleModule")
  @TestDataPath("$PROJECT_ROOT")
  public class SingleModule {
    @Test
    public void testAllFilesPresentInSingleModule() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/resolveExtensions/referenceResolve/singleModule"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("classMember.kt")
    public void testClassMember() {
      runTest("analysis/analysis-api/testData/resolveExtensions/referenceResolve/singleModule/classMember.kt");
    }

    @Test
    @TestMetadata("extensionFunction.kt")
    public void testExtensionFunction() {
      runTest("analysis/analysis-api/testData/resolveExtensions/referenceResolve/singleModule/extensionFunction.kt");
    }

    @Test
    @TestMetadata("shadowedDeclaration.kt")
    public void testShadowedDeclaration() {
      runTest("analysis/analysis-api/testData/resolveExtensions/referenceResolve/singleModule/shadowedDeclaration.kt");
    }

    @Test
    @TestMetadata("shadowedJava.kt")
    public void testShadowedJava() {
      runTest("analysis/analysis-api/testData/resolveExtensions/referenceResolve/singleModule/shadowedJava.kt");
    }

    @Test
    @TestMetadata("shadowedOverload.kt")
    public void testShadowedOverload() {
      runTest("analysis/analysis-api/testData/resolveExtensions/referenceResolve/singleModule/shadowedOverload.kt");
    }

    @Test
    @TestMetadata("topLevelFunction.kt")
    public void testTopLevelFunction() {
      runTest("analysis/analysis-api/testData/resolveExtensions/referenceResolve/singleModule/topLevelFunction.kt");
    }
  }
}
