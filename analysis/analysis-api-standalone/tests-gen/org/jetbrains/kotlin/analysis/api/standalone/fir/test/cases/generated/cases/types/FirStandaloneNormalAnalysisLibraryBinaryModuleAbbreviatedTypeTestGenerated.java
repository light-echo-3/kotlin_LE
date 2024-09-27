/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.standalone.fir.test.cases.generated.cases.types;

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
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.types.AbstractAbbreviatedTypeTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/types/abbreviatedType")
@TestDataPath("$PROJECT_ROOT")
public class FirStandaloneNormalAnalysisLibraryBinaryModuleAbbreviatedTypeTestGenerated extends AbstractAbbreviatedTypeTest {
  @NotNull
  @Override
  public AnalysisApiTestConfigurator getConfigurator() {
    return AnalysisApiFirStandaloneModeTestConfiguratorFactory.INSTANCE.createConfigurator(
      new AnalysisApiTestConfiguratorFactoryData(
        FrontendKind.Fir,
        TestModuleKind.LibraryBinary,
        AnalysisSessionMode.Normal,
        AnalysisApiMode.Standalone
      )
    );
  }

  @Test
  public void testAllFilesPresentInAbbreviatedType() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/types/abbreviatedType"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Test
  @TestMetadata("FunctionAlias.kt")
  public void testFunctionAlias() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/FunctionAlias.kt");
  }

  @Test
  @TestMetadata("FunctionAliasFromLibrary.kt")
  public void testFunctionAliasFromLibrary() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/FunctionAliasFromLibrary.kt");
  }

  @Test
  @TestMetadata("FunctionAliasNullable.kt")
  public void testFunctionAliasNullable() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/FunctionAliasNullable.kt");
  }

  @Test
  @TestMetadata("FunctionAliasNullableFromLibrary.kt")
  public void testFunctionAliasNullableFromLibrary() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/FunctionAliasNullableFromLibrary.kt");
  }

  @Test
  @TestMetadata("ListAlias.kt")
  public void testListAlias() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/ListAlias.kt");
  }

  @Test
  @TestMetadata("ListAliasFromLibrary.kt")
  public void testListAliasFromLibrary() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/ListAliasFromLibrary.kt");
  }

  @Test
  @TestMetadata("NestedAsymmetricAlias.kt")
  public void testNestedAsymmetricAlias() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/NestedAsymmetricAlias.kt");
  }

  @Test
  @TestMetadata("NestedAsymmetricAliasFromLibrary.kt")
  public void testNestedAsymmetricAliasFromLibrary() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/NestedAsymmetricAliasFromLibrary.kt");
  }

  @Test
  @TestMetadata("NestedCollectionAliases.kt")
  public void testNestedCollectionAliases() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/NestedCollectionAliases.kt");
  }

  @Test
  @TestMetadata("NestedCollectionAliasesFromLibrary.kt")
  public void testNestedCollectionAliasesFromLibrary() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/NestedCollectionAliasesFromLibrary.kt");
  }

  @Test
  @TestMetadata("NullableFunctionAlias.kt")
  public void testNullableFunctionAlias() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/NullableFunctionAlias.kt");
  }

  @Test
  @TestMetadata("NullableFunctionAliasFromLibrary.kt")
  public void testNullableFunctionAliasFromLibrary() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/NullableFunctionAliasFromLibrary.kt");
  }

  @Test
  @TestMetadata("NullableStringAlias.kt")
  public void testNullableStringAlias() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/NullableStringAlias.kt");
  }

  @Test
  @TestMetadata("NullableStringAliasFromLibrary.kt")
  public void testNullableStringAliasFromLibrary() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/NullableStringAliasFromLibrary.kt");
  }

  @Test
  @TestMetadata("NullableTransitiveStringAlias.kt")
  public void testNullableTransitiveStringAlias() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/NullableTransitiveStringAlias.kt");
  }

  @Test
  @TestMetadata("NullableTransitiveStringAliasFromLibrary.kt")
  public void testNullableTransitiveStringAliasFromLibrary() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/NullableTransitiveStringAliasFromLibrary.kt");
  }

  @Test
  @TestMetadata("ParameterizedFunctionAlias.kt")
  public void testParameterizedFunctionAlias() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/ParameterizedFunctionAlias.kt");
  }

  @Test
  @TestMetadata("ParameterizedFunctionAliasFromLibrary.kt")
  public void testParameterizedFunctionAliasFromLibrary() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/ParameterizedFunctionAliasFromLibrary.kt");
  }

  @Test
  @TestMetadata("StringAlias.kt")
  public void testStringAlias() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/StringAlias.kt");
  }

  @Test
  @TestMetadata("StringAliasFromLibrary.kt")
  public void testStringAliasFromLibrary() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/StringAliasFromLibrary.kt");
  }

  @Test
  @TestMetadata("StringAliasNullable.kt")
  public void testStringAliasNullable() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/StringAliasNullable.kt");
  }

  @Test
  @TestMetadata("StringAliasNullableFromLibrary.kt")
  public void testStringAliasNullableFromLibrary() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/StringAliasNullableFromLibrary.kt");
  }

  @Test
  @TestMetadata("TransitiveNullableStringAlias.kt")
  public void testTransitiveNullableStringAlias() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/TransitiveNullableStringAlias.kt");
  }

  @Test
  @TestMetadata("TransitiveNullableStringAliasFromLibrary.kt")
  public void testTransitiveNullableStringAliasFromLibrary() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/TransitiveNullableStringAliasFromLibrary.kt");
  }

  @Test
  @TestMetadata("TransitiveStringAlias.kt")
  public void testTransitiveStringAlias() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/TransitiveStringAlias.kt");
  }

  @Test
  @TestMetadata("TransitiveStringAliasFromLibrary.kt")
  public void testTransitiveStringAliasFromLibrary() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/TransitiveStringAliasFromLibrary.kt");
  }

  @Test
  @TestMetadata("TransitiveStringAliasNullable.kt")
  public void testTransitiveStringAliasNullable() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/TransitiveStringAliasNullable.kt");
  }

  @Test
  @TestMetadata("TransitiveStringAliasNullableFromLibrary.kt")
  public void testTransitiveStringAliasNullableFromLibrary() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/TransitiveStringAliasNullableFromLibrary.kt");
  }

  @Test
  @TestMetadata("UnresolvedExpandedType.kt")
  public void testUnresolvedExpandedType() {
    runTest("analysis/analysis-api/testData/types/abbreviatedType/UnresolvedExpandedType.kt");
  }
}
