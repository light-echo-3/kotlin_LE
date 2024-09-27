/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.test.cases.generated.cases.components.expressionTypeProvider;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.analysis.api.fir.test.configurators.AnalysisApiFirTestConfiguratorFactory;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfiguratorFactoryData;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfigurator;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.TestModuleKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.FrontendKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisSessionMode;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiMode;
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.expressionTypeProvider.AbstractHLExpressionTypeTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeDependentAnalysisSourceModuleHLExpressionTypeTestGenerated extends AbstractHLExpressionTypeTest {
  @NotNull
  @Override
  public AnalysisApiTestConfigurator getConfigurator() {
    return AnalysisApiFirTestConfiguratorFactory.INSTANCE.createConfigurator(
      new AnalysisApiTestConfiguratorFactoryData(
        FrontendKind.Fir,
        TestModuleKind.Source,
        AnalysisSessionMode.Dependent,
        AnalysisApiMode.Ide
      )
    );
  }

  @Test
  public void testAllFilesPresentInExpressionType() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Test
  @TestMetadata("anonymousFunction.kt")
  public void testAnonymousFunction() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/anonymousFunction.kt");
  }

  @Test
  @TestMetadata("approximatedCapturedFlexible.kt")
  public void testApproximatedCapturedFlexible() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/approximatedCapturedFlexible.kt");
  }

  @Test
  @TestMetadata("arrayElement_arrayOfNulls.kt")
  public void testArrayElement_arrayOfNulls() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/arrayElement_arrayOfNulls.kt");
  }

  @Test
  @TestMetadata("array_arrayOfNulls.kt")
  public void testArray_arrayOfNulls() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/array_arrayOfNulls.kt");
  }

  @Test
  @TestMetadata("assignmentExpressionTarget.kt")
  public void testAssignmentExpressionTarget() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/assignmentExpressionTarget.kt");
  }

  @Test
  @TestMetadata("binaryExpression.kt")
  public void testBinaryExpression() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/binaryExpression.kt");
  }

  @Test
  @TestMetadata("breakExpression.kt")
  public void testBreakExpression() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/breakExpression.kt");
  }

  @Test
  @TestMetadata("callableReference_consumer.kt")
  public void testCallableReference_consumer() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/callableReference_consumer.kt");
  }

  @Test
  @TestMetadata("callableReference_function.kt")
  public void testCallableReference_function() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/callableReference_function.kt");
  }

  @Test
  @TestMetadata("forExpression.kt")
  public void testForExpression() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/forExpression.kt");
  }

  @Test
  @TestMetadata("functionCall.kt")
  public void testFunctionCall() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/functionCall.kt");
  }

  @Test
  @TestMetadata("inParens.kt")
  public void testInParens() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/inParens.kt");
  }

  @Test
  @TestMetadata("incompleteGet.kt")
  public void testIncompleteGet() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/incompleteGet.kt");
  }

  @Test
  @TestMetadata("insideStringTemplate.kt")
  public void testInsideStringTemplate() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/insideStringTemplate.kt");
  }

  @Test
  @TestMetadata("insideStringTemplateWithBinrary.kt")
  public void testInsideStringTemplateWithBinrary() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/insideStringTemplateWithBinrary.kt");
  }

  @Test
  @TestMetadata("intLiteral.kt")
  public void testIntLiteral() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/intLiteral.kt");
  }

  @Test
  @TestMetadata("javaEnhancedType.kt")
  public void testJavaEnhancedType() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/javaEnhancedType.kt");
  }

  @Test
  @TestMetadata("javaEnhancedTypeExternalAnnotation.kt")
  public void testJavaEnhancedTypeExternalAnnotation() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/javaEnhancedTypeExternalAnnotation.kt");
  }

  @Test
  @TestMetadata("listElement_listOf.kt")
  public void testListElement_listOf() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/listElement_listOf.kt");
  }

  @Test
  @TestMetadata("listElement_mutableListOf.kt")
  public void testListElement_mutableListOf() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/listElement_mutableListOf.kt");
  }

  @Test
  @TestMetadata("list_listOf.kt")
  public void testList_listOf() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/list_listOf.kt");
  }

  @Test
  @TestMetadata("list_mutableListOf.kt")
  public void testList_mutableListOf() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/list_mutableListOf.kt");
  }

  @Test
  @TestMetadata("methodReference_instance_convertedTo_Runnable.kt")
  public void testMethodReference_instance_convertedTo_Runnable() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/methodReference_instance_convertedTo_Runnable.kt");
  }

  @Test
  @TestMetadata("methodReference_instance_convertedTo_Supplier.kt")
  public void testMethodReference_instance_convertedTo_Supplier() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/methodReference_instance_convertedTo_Supplier.kt");
  }

  @Test
  @TestMetadata("nameReference.kt")
  public void testNameReference() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference.kt");
  }

  @Test
  @TestMetadata("nonExpression.kt")
  public void testNonExpression() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nonExpression.kt");
  }

  @Test
  @TestMetadata("platformType.kt")
  public void testPlatformType() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/platformType.kt");
  }

  @Test
  @TestMetadata("plusAssign.kt")
  public void testPlusAssign() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/plusAssign.kt");
  }

  @Test
  @TestMetadata("postfixDec.kt")
  public void testPostfixDec() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/postfixDec.kt");
  }

  @Test
  @TestMetadata("prefixInc.kt")
  public void testPrefixInc() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/prefixInc.kt");
  }

  @Test
  @TestMetadata("property.kt")
  public void testProperty() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/property.kt");
  }

  @Test
  @TestMetadata("resolvedSuper.kt")
  public void testResolvedSuper() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/resolvedSuper.kt");
  }

  @Test
  @TestMetadata("returnExpression.kt")
  public void testReturnExpression() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/returnExpression.kt");
  }

  @Test
  @TestMetadata("singleExpressionLambdaBody.kt")
  public void testSingleExpressionLambdaBody() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/singleExpressionLambdaBody.kt");
  }

  @Test
  @TestMetadata("smartcast_asCallArg.kt")
  public void testSmartcast_asCallArg() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/smartcast_asCallArg.kt");
  }

  @Test
  @TestMetadata("smartcast_asReceiver.kt")
  public void testSmartcast_asReceiver() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/smartcast_asReceiver.kt");
  }

  @Test
  @TestMetadata("smartcast_multi.kt")
  public void testSmartcast_multi() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/smartcast_multi.kt");
  }

  @Test
  @TestMetadata("smartcast_unused.kt")
  public void testSmartcast_unused() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/smartcast_unused.kt");
  }

  @Test
  @TestMetadata("stringLiteral.kt")
  public void testStringLiteral() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/stringLiteral.kt");
  }

  @Test
  @TestMetadata("underscoreTypeArgument.kt")
  public void testUnderscoreTypeArgument() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/underscoreTypeArgument.kt");
  }

  @Test
  @TestMetadata("unresolvedSuper_multipleSuperTypes.kt")
  public void testUnresolvedSuper_multipleSuperTypes() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/unresolvedSuper_multipleSuperTypes.kt");
  }

  @Test
  @TestMetadata("unresolvedSuper_noSuperType.kt")
  public void testUnresolvedSuper_noSuperType() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/unresolvedSuper_noSuperType.kt");
  }

  @Test
  @TestMetadata("unresolvedSuper_singleSuperType.kt")
  public void testUnresolvedSuper_singleSuperType() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/unresolvedSuper_singleSuperType.kt");
  }

  @Test
  @TestMetadata("whileExpression.kt")
  public void testWhileExpression() {
    runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/whileExpression.kt");
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/approximatedLocalClasses")
  @TestDataPath("$PROJECT_ROOT")
  public class ApproximatedLocalClasses {
    @Test
    @TestMetadata("accessibleLocalType.kt")
    public void testAccessibleLocalType() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/approximatedLocalClasses/accessibleLocalType.kt");
    }

    @Test
    public void testAllFilesPresentInApproximatedLocalClasses() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/approximatedLocalClasses"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("deeperHierarchy1.kt")
    public void testDeeperHierarchy1() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/approximatedLocalClasses/deeperHierarchy1.kt");
    }

    @Test
    @TestMetadata("deeperHierarchy2.kt")
    public void testDeeperHierarchy2() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/approximatedLocalClasses/deeperHierarchy2.kt");
    }

    @Test
    @TestMetadata("deeperHierarchy3.kt")
    public void testDeeperHierarchy3() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/approximatedLocalClasses/deeperHierarchy3.kt");
    }

    @Test
    @TestMetadata("deeperHierarchy4.kt")
    public void testDeeperHierarchy4() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/approximatedLocalClasses/deeperHierarchy4.kt");
    }

    @Test
    @TestMetadata("simple.kt")
    public void testSimple() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/approximatedLocalClasses/simple.kt");
    }
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/assignment")
  @TestDataPath("$PROJECT_ROOT")
  public class Assignment {
    @Test
    public void testAllFilesPresentInAssignment() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/assignment"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("arrayAssignementTarget.kt")
    public void testArrayAssignementTarget() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/assignment/arrayAssignementTarget.kt");
    }

    @Test
    @TestMetadata("arrayAssignmentTargetUnresovledSet.kt")
    public void testArrayAssignmentTargetUnresovledSet() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/assignment/arrayAssignmentTargetUnresovledSet.kt");
    }

    @Test
    @TestMetadata("arrayAssignmentTargetWithTypeParameters.kt")
    public void testArrayAssignmentTargetWithTypeParameters() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/assignment/arrayAssignmentTargetWithTypeParameters.kt");
    }

    @Test
    @TestMetadata("arrayCompoundAssignementTarget.kt")
    public void testArrayCompoundAssignementTarget() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/assignment/arrayCompoundAssignementTarget.kt");
    }

    @Test
    @TestMetadata("augmentedArrayAssigment.kt")
    public void testAugmentedArrayAssigment() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/assignment/augmentedArrayAssigment.kt");
    }

    @Test
    @TestMetadata("readArrayElement.kt")
    public void testReadArrayElement() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/assignment/readArrayElement.kt");
    }
  }

  @Nested
  @TestMetadata("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference")
  @TestDataPath("$PROJECT_ROOT")
  public class NameReference {
    @Test
    public void testAllFilesPresentInNameReference() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("assignment.kt")
    public void testAssignment() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/assignment.kt");
    }

    @Test
    @TestMetadata("assignment_qualified.kt")
    public void testAssignment_qualified() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/assignment_qualified.kt");
    }

    @Test
    @TestMetadata("callableReference.kt")
    public void testCallableReference() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/callableReference.kt");
    }

    @Test
    @TestMetadata("capturedBoundType.kt")
    public void testCapturedBoundType() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/capturedBoundType.kt");
    }

    @Test
    @TestMetadata("functionCall.kt")
    public void testFunctionCall() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/functionCall.kt");
    }

    @Test
    @TestMetadata("functionCall_invalid.kt")
    public void testFunctionCall_invalid() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/functionCall_invalid.kt");
    }

    @Test
    @TestMetadata("functionCall_safeAccess.kt")
    public void testFunctionCall_safeAccess() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/functionCall_safeAccess.kt");
    }

    @Test
    @TestMetadata("functionalType.kt")
    public void testFunctionalType() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/functionalType.kt");
    }

    @Test
    @TestMetadata("functionalType_parens_1.kt")
    public void testFunctionalType_parens_1() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/functionalType_parens_1.kt");
    }

    @Test
    @TestMetadata("functionalType_parens_2.kt")
    public void testFunctionalType_parens_2() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/functionalType_parens_2.kt");
    }

    @Test
    @TestMetadata("functionalType_withReceiver.kt")
    public void testFunctionalType_withReceiver() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/functionalType_withReceiver.kt");
    }

    @Test
    @TestMetadata("innerType_constructor.kt")
    public void testInnerType_constructor() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/innerType_constructor.kt");
    }

    @Test
    @TestMetadata("innerType_constructor_invalid.kt")
    public void testInnerType_constructor_invalid() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/innerType_constructor_invalid.kt");
    }

    @Test
    @TestMetadata("invokeCallOnObject1.kt")
    public void testInvokeCallOnObject1() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/invokeCallOnObject1.kt");
    }

    @Test
    @TestMetadata("invokeCallOnObject2.kt")
    public void testInvokeCallOnObject2() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/invokeCallOnObject2.kt");
    }

    @Test
    @TestMetadata("nestedType_constructor.kt")
    public void testNestedType_constructor() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/nestedType_constructor.kt");
    }

    @Test
    @TestMetadata("nestedType_constructor_invalid.kt")
    public void testNestedType_constructor_invalid() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/nestedType_constructor_invalid.kt");
    }

    @Test
    @TestMetadata("nestedType_object.kt")
    public void testNestedType_object() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/nestedType_object.kt");
    }

    @Test
    @TestMetadata("nestedType_object_extensionInvoke.kt")
    public void testNestedType_object_extensionInvoke() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/nestedType_object_extensionInvoke.kt");
    }

    @Test
    @TestMetadata("propertyCall.kt")
    public void testPropertyCall() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/propertyCall.kt");
    }

    @Test
    @TestMetadata("propertyCall_genericExtension.kt")
    public void testPropertyCall_genericExtension() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/propertyCall_genericExtension.kt");
    }

    @Test
    @TestMetadata("propertyCall_safeAccess.kt")
    public void testPropertyCall_safeAccess() {
      runTest("analysis/analysis-api/testData/components/expressionTypeProvider/expressionType/nameReference/propertyCall_safeAccess.kt");
    }
  }
}
