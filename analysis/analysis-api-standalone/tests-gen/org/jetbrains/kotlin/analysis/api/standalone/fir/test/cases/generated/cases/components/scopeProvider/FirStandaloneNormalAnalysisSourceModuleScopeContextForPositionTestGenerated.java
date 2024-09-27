/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.standalone.fir.test.cases.generated.cases.components.scopeProvider;

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
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.scopeProvider.AbstractScopeContextForPositionTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition")
@TestDataPath("$PROJECT_ROOT")
public class FirStandaloneNormalAnalysisSourceModuleScopeContextForPositionTestGenerated extends AbstractScopeContextForPositionTest {
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
  public void testAllFilesPresentInScopeContextForPosition() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Test
  @TestMetadata("annotationWithoutDeclaration.kt")
  public void testAnnotationWithoutDeclaration() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/annotationWithoutDeclaration.kt");
  }

  @Test
  @TestMetadata("classPropertyDelegate.kt")
  public void testClassPropertyDelegate() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/classPropertyDelegate.kt");
  }

  @Test
  @TestMetadata("classPropertyInitializer.kt")
  public void testClassPropertyInitializer() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/classPropertyInitializer.kt");
  }

  @Test
  @TestMetadata("contextReceiver.kt")
  public void testContextReceiver() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/contextReceiver.kt");
  }

  @Test
  @TestMetadata("contextReceiverWithoutDeclaration.kt")
  public void testContextReceiverWithoutDeclaration() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/contextReceiverWithoutDeclaration.kt");
  }

  @Test
  @TestMetadata("emptyContextForPositionInImportDirective.kt")
  public void testEmptyContextForPositionInImportDirective() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/emptyContextForPositionInImportDirective.kt");
  }

  @Test
  @TestMetadata("emptyContextForPositionInPackageDirective.kt")
  public void testEmptyContextForPositionInPackageDirective() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/emptyContextForPositionInPackageDirective.kt");
  }

  @Test
  @TestMetadata("enumEntry.kt")
  public void testEnumEntry() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/enumEntry.kt");
  }

  @Test
  @TestMetadata("errorType.kt")
  public void testErrorType() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/errorType.kt");
  }

  @Test
  @TestMetadata("forLoopVariable.kt")
  public void testForLoopVariable() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/forLoopVariable.kt");
  }

  @Test
  @TestMetadata("kDocOnClass.kt")
  public void testKDocOnClass() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/kDocOnClass.kt");
  }

  @Test
  @TestMetadata("kDocOnFunction.kt")
  public void testKDocOnFunction() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/kDocOnFunction.kt");
  }

  @Test
  @TestMetadata("kDocWithoutDeclaration.kt")
  public void testKDocWithoutDeclaration() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/kDocWithoutDeclaration.kt");
  }

  @Test
  @TestMetadata("localTypeScope.kt")
  public void testLocalTypeScope() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/localTypeScope.kt");
  }

  @Test
  @TestMetadata("notEnabledKotlinPackage.kt")
  public void testNotEnabledKotlinPackage() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/notEnabledKotlinPackage.kt");
  }

  @Test
  @TestMetadata("simpleScopeContextForPosition.kt")
  public void testSimpleScopeContextForPosition() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/simpleScopeContextForPosition.kt");
  }

  @Test
  @TestMetadata("smartCastInAnonymousFunction.kt")
  public void testSmartCastInAnonymousFunction() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/smartCastInAnonymousFunction.kt");
  }

  @Test
  @TestMetadata("smartCastInAnonymousFunctionInWhenEntry.kt")
  public void testSmartCastInAnonymousFunctionInWhenEntry() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/smartCastInAnonymousFunctionInWhenEntry.kt");
  }

  @Test
  @TestMetadata("smartCastInWhenEntryCondition.kt")
  public void testSmartCastInWhenEntryCondition() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/smartCastInWhenEntryCondition.kt");
  }

  @Test
  @TestMetadata("superTypeConstructor.kt")
  public void testSuperTypeConstructor() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/superTypeConstructor.kt");
  }

  @Test
  @TestMetadata("superTypeConstructor_lambda.kt")
  public void testSuperTypeConstructor_lambda() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/superTypeConstructor_lambda.kt");
  }

  @Test
  @TestMetadata("superTypeConstructor_nestedClasses.kt")
  public void testSuperTypeConstructor_nestedClasses() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/superTypeConstructor_nestedClasses.kt");
  }

  @Test
  @TestMetadata("superTypeConstructor_nestedClasses_typeArgument.kt")
  public void testSuperTypeConstructor_nestedClasses_typeArgument() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/superTypeConstructor_nestedClasses_typeArgument.kt");
  }

  @Test
  @TestMetadata("superTypeDelegate.kt")
  public void testSuperTypeDelegate() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/superTypeDelegate.kt");
  }

  @Test
  @TestMetadata("syntheticPropertiesScope.kt")
  public void testSyntheticPropertiesScope() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/syntheticPropertiesScope.kt");
  }

  @Test
  @TestMetadata("valueClassFromPackage.kt")
  public void testValueClassFromPackage() {
    runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/valueClassFromPackage.kt");
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/withTestCompilerPluginEnabled")
  @TestDataPath("$PROJECT_ROOT")
  public class WithTestCompilerPluginEnabled {
    @Test
    public void testAllFilesPresentInWithTestCompilerPluginEnabled() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/withTestCompilerPluginEnabled"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("callShapeBasedInjector_receiver.kt")
    public void testCallShapeBasedInjector_receiver() {
      runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/withTestCompilerPluginEnabled/callShapeBasedInjector_receiver.kt");
    }

    @Test
    @TestMetadata("callShapeBasedInjector_variable.kt")
    public void testCallShapeBasedInjector_variable() {
      runTest("analysis/analysis-api/testData/components/scopeProvider/scopeContextForPosition/withTestCompilerPluginEnabled/callShapeBasedInjector_variable.kt");
    }
  }
}
