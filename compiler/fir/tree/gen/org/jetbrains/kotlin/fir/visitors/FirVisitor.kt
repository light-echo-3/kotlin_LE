/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

// This file was generated automatically. See compiler/fir/tree/tree-generator/Readme.md.
// DO NOT MODIFY IT MANUALLY.

package org.jetbrains.kotlin.fir.visitors

import org.jetbrains.kotlin.fir.*
import org.jetbrains.kotlin.fir.contracts.*
import org.jetbrains.kotlin.fir.declarations.*
import org.jetbrains.kotlin.fir.diagnostics.FirDiagnosticHolder
import org.jetbrains.kotlin.fir.expressions.*
import org.jetbrains.kotlin.fir.references.*
import org.jetbrains.kotlin.fir.types.*

/**
 * Auto-generated by [org.jetbrains.kotlin.fir.tree.generator.printer.VisitorPrinter]
 */
abstract class FirVisitor<out R, in D> {

    abstract fun visitElement(element: FirElement, data: D): R

    open fun visitAnnotationContainer(annotationContainer: FirAnnotationContainer, data: D): R =
        visitElement(annotationContainer, data)

    open fun visitTypeRef(typeRef: FirTypeRef, data: D): R =
        visitElement(typeRef, data)

    open fun visitReference(reference: FirReference, data: D): R =
        visitElement(reference, data)

    open fun visitLabel(label: FirLabel, data: D): R =
        visitElement(label, data)

    open fun visitResolvable(resolvable: FirResolvable, data: D): R =
        visitElement(resolvable, data)

    open fun visitTargetElement(targetElement: FirTargetElement, data: D): R =
        visitElement(targetElement, data)

    open fun visitDeclarationStatus(declarationStatus: FirDeclarationStatus, data: D): R =
        visitElement(declarationStatus, data)

    open fun visitResolvedDeclarationStatus(resolvedDeclarationStatus: FirResolvedDeclarationStatus, data: D): R =
        visitElement(resolvedDeclarationStatus, data)

    open fun visitControlFlowGraphOwner(controlFlowGraphOwner: FirControlFlowGraphOwner, data: D): R =
        visitElement(controlFlowGraphOwner, data)

    open fun visitStatement(statement: FirStatement, data: D): R =
        visitElement(statement, data)

    open fun visitExpression(expression: FirExpression, data: D): R =
        visitElement(expression, data)

    open fun visitLazyExpression(lazyExpression: FirLazyExpression, data: D): R =
        visitElement(lazyExpression, data)

    open fun visitContextReceiver(contextReceiver: FirContextReceiver, data: D): R =
        visitElement(contextReceiver, data)

    open fun visitElementWithResolveState(elementWithResolveState: FirElementWithResolveState, data: D): R =
        visitElement(elementWithResolveState, data)

    open fun visitFileAnnotationsContainer(fileAnnotationsContainer: FirFileAnnotationsContainer, data: D): R =
        visitElement(fileAnnotationsContainer, data)

    open fun visitDeclaration(declaration: FirDeclaration, data: D): R =
        visitElement(declaration, data)

    open fun visitTypeParameterRefsOwner(typeParameterRefsOwner: FirTypeParameterRefsOwner, data: D): R =
        visitElement(typeParameterRefsOwner, data)

    open fun visitTypeParametersOwner(typeParametersOwner: FirTypeParametersOwner, data: D): R =
        visitElement(typeParametersOwner, data)

    open fun visitMemberDeclaration(memberDeclaration: FirMemberDeclaration, data: D): R =
        visitElement(memberDeclaration, data)

    open fun visitAnonymousInitializer(anonymousInitializer: FirAnonymousInitializer, data: D): R =
        visitElement(anonymousInitializer, data)

    open fun visitCallableDeclaration(callableDeclaration: FirCallableDeclaration, data: D): R =
        visitElement(callableDeclaration, data)

    open fun visitTypeParameterRef(typeParameterRef: FirTypeParameterRef, data: D): R =
        visitElement(typeParameterRef, data)

    open fun visitTypeParameter(typeParameter: FirTypeParameter, data: D): R =
        visitElement(typeParameter, data)

    open fun visitConstructedClassTypeParameterRef(constructedClassTypeParameterRef: FirConstructedClassTypeParameterRef, data: D): R =
        visitElement(constructedClassTypeParameterRef, data)

    open fun visitOuterClassTypeParameterRef(outerClassTypeParameterRef: FirOuterClassTypeParameterRef, data: D): R =
        visitElement(outerClassTypeParameterRef, data)

    open fun visitVariable(variable: FirVariable, data: D): R =
        visitElement(variable, data)

    open fun visitValueParameter(valueParameter: FirValueParameter, data: D): R =
        visitElement(valueParameter, data)

    open fun visitReceiverParameter(receiverParameter: FirReceiverParameter, data: D): R =
        visitElement(receiverParameter, data)

    open fun visitProperty(property: FirProperty, data: D): R =
        visitElement(property, data)

    open fun visitField(field: FirField, data: D): R =
        visitElement(field, data)

    open fun visitEnumEntry(enumEntry: FirEnumEntry, data: D): R =
        visitElement(enumEntry, data)

    open fun visitFunctionTypeParameter(functionTypeParameter: FirFunctionTypeParameter, data: D): R =
        visitElement(functionTypeParameter, data)

    open fun visitClassLikeDeclaration(classLikeDeclaration: FirClassLikeDeclaration, data: D): R =
        visitElement(classLikeDeclaration, data)

    open fun visitClass(klass: FirClass, data: D): R =
        visitElement(klass, data)

    open fun visitRegularClass(regularClass: FirRegularClass, data: D): R =
        visitElement(regularClass, data)

    open fun visitTypeAlias(typeAlias: FirTypeAlias, data: D): R =
        visitElement(typeAlias, data)

    open fun visitFunction(function: FirFunction, data: D): R =
        visitElement(function, data)

    open fun visitContractDescriptionOwner(contractDescriptionOwner: FirContractDescriptionOwner, data: D): R =
        visitElement(contractDescriptionOwner, data)

    open fun visitSimpleFunction(simpleFunction: FirSimpleFunction, data: D): R =
        visitElement(simpleFunction, data)

    open fun visitPropertyAccessor(propertyAccessor: FirPropertyAccessor, data: D): R =
        visitElement(propertyAccessor, data)

    open fun visitBackingField(backingField: FirBackingField, data: D): R =
        visitElement(backingField, data)

    open fun visitConstructor(constructor: FirConstructor, data: D): R =
        visitElement(constructor, data)

    open fun visitFile(file: FirFile, data: D): R =
        visitElement(file, data)

    open fun visitScript(script: FirScript, data: D): R =
        visitElement(script, data)

    open fun visitCodeFragment(codeFragment: FirCodeFragment, data: D): R =
        visitElement(codeFragment, data)

    open fun visitPackageDirective(packageDirective: FirPackageDirective, data: D): R =
        visitElement(packageDirective, data)

    open fun visitAnonymousFunction(anonymousFunction: FirAnonymousFunction, data: D): R =
        visitElement(anonymousFunction, data)

    open fun visitAnonymousFunctionExpression(anonymousFunctionExpression: FirAnonymousFunctionExpression, data: D): R =
        visitElement(anonymousFunctionExpression, data)

    open fun visitAnonymousObject(anonymousObject: FirAnonymousObject, data: D): R =
        visitElement(anonymousObject, data)

    open fun visitAnonymousObjectExpression(anonymousObjectExpression: FirAnonymousObjectExpression, data: D): R =
        visitElement(anonymousObjectExpression, data)

    open fun visitDiagnosticHolder(diagnosticHolder: FirDiagnosticHolder, data: D): R =
        visitElement(diagnosticHolder, data)

    open fun visitImport(import: FirImport, data: D): R =
        visitElement(import, data)

    open fun visitResolvedImport(resolvedImport: FirResolvedImport, data: D): R =
        visitElement(resolvedImport, data)

    open fun visitErrorImport(errorImport: FirErrorImport, data: D): R =
        visitElement(errorImport, data)

    open fun visitLoop(loop: FirLoop, data: D): R =
        visitElement(loop, data)

    open fun visitErrorLoop(errorLoop: FirErrorLoop, data: D): R =
        visitElement(errorLoop, data)

    open fun visitDoWhileLoop(doWhileLoop: FirDoWhileLoop, data: D): R =
        visitElement(doWhileLoop, data)

    open fun visitWhileLoop(whileLoop: FirWhileLoop, data: D): R =
        visitElement(whileLoop, data)

    open fun visitBlock(block: FirBlock, data: D): R =
        visitElement(block, data)

    open fun visitLazyBlock(lazyBlock: FirLazyBlock, data: D): R =
        visitElement(lazyBlock, data)

    open fun visitBinaryLogicExpression(binaryLogicExpression: FirBinaryLogicExpression, data: D): R =
        visitElement(binaryLogicExpression, data)

    open fun <E : FirTargetElement> visitJump(jump: FirJump<E>, data: D): R =
        visitElement(jump, data)

    open fun visitLoopJump(loopJump: FirLoopJump, data: D): R =
        visitElement(loopJump, data)

    open fun visitBreakExpression(breakExpression: FirBreakExpression, data: D): R =
        visitElement(breakExpression, data)

    open fun visitContinueExpression(continueExpression: FirContinueExpression, data: D): R =
        visitElement(continueExpression, data)

    open fun visitCatch(catch: FirCatch, data: D): R =
        visitElement(catch, data)

    open fun visitTryExpression(tryExpression: FirTryExpression, data: D): R =
        visitElement(tryExpression, data)

    open fun <T> visitConstExpression(constExpression: FirConstExpression<T>, data: D): R =
        visitElement(constExpression, data)

    open fun visitTypeProjection(typeProjection: FirTypeProjection, data: D): R =
        visitElement(typeProjection, data)

    open fun visitStarProjection(starProjection: FirStarProjection, data: D): R =
        visitElement(starProjection, data)

    open fun visitPlaceholderProjection(placeholderProjection: FirPlaceholderProjection, data: D): R =
        visitElement(placeholderProjection, data)

    open fun visitTypeProjectionWithVariance(typeProjectionWithVariance: FirTypeProjectionWithVariance, data: D): R =
        visitElement(typeProjectionWithVariance, data)

    open fun visitArgumentList(argumentList: FirArgumentList, data: D): R =
        visitElement(argumentList, data)

    open fun visitCall(call: FirCall, data: D): R =
        visitElement(call, data)

    open fun visitAnnotation(annotation: FirAnnotation, data: D): R =
        visitElement(annotation, data)

    open fun visitAnnotationCall(annotationCall: FirAnnotationCall, data: D): R =
        visitElement(annotationCall, data)

    open fun visitAnnotationArgumentMapping(annotationArgumentMapping: FirAnnotationArgumentMapping, data: D): R =
        visitElement(annotationArgumentMapping, data)

    open fun visitErrorAnnotationCall(errorAnnotationCall: FirErrorAnnotationCall, data: D): R =
        visitElement(errorAnnotationCall, data)

    open fun visitComparisonExpression(comparisonExpression: FirComparisonExpression, data: D): R =
        visitElement(comparisonExpression, data)

    open fun visitTypeOperatorCall(typeOperatorCall: FirTypeOperatorCall, data: D): R =
        visitElement(typeOperatorCall, data)

    open fun visitAssignmentOperatorStatement(assignmentOperatorStatement: FirAssignmentOperatorStatement, data: D): R =
        visitElement(assignmentOperatorStatement, data)

    open fun visitIncrementDecrementExpression(incrementDecrementExpression: FirIncrementDecrementExpression, data: D): R =
        visitElement(incrementDecrementExpression, data)

    open fun visitEqualityOperatorCall(equalityOperatorCall: FirEqualityOperatorCall, data: D): R =
        visitElement(equalityOperatorCall, data)

    open fun visitWhenExpression(whenExpression: FirWhenExpression, data: D): R =
        visitElement(whenExpression, data)

    open fun visitWhenBranch(whenBranch: FirWhenBranch, data: D): R =
        visitElement(whenBranch, data)

    open fun visitContextReceiverArgumentListOwner(contextReceiverArgumentListOwner: FirContextReceiverArgumentListOwner, data: D): R =
        visitElement(contextReceiverArgumentListOwner, data)

    open fun visitCheckNotNullCall(checkNotNullCall: FirCheckNotNullCall, data: D): R =
        visitElement(checkNotNullCall, data)

    open fun visitElvisExpression(elvisExpression: FirElvisExpression, data: D): R =
        visitElement(elvisExpression, data)

    open fun visitArrayLiteral(arrayLiteral: FirArrayLiteral, data: D): R =
        visitElement(arrayLiteral, data)

    open fun visitAugmentedArraySetCall(augmentedArraySetCall: FirAugmentedArraySetCall, data: D): R =
        visitElement(augmentedArraySetCall, data)

    open fun visitClassReferenceExpression(classReferenceExpression: FirClassReferenceExpression, data: D): R =
        visitElement(classReferenceExpression, data)

    open fun visitErrorExpression(errorExpression: FirErrorExpression, data: D): R =
        visitElement(errorExpression, data)

    open fun visitErrorFunction(errorFunction: FirErrorFunction, data: D): R =
        visitElement(errorFunction, data)

    open fun visitErrorProperty(errorProperty: FirErrorProperty, data: D): R =
        visitElement(errorProperty, data)

    open fun visitErrorPrimaryConstructor(errorPrimaryConstructor: FirErrorPrimaryConstructor, data: D): R =
        visitElement(errorPrimaryConstructor, data)

    open fun visitDanglingModifierList(danglingModifierList: FirDanglingModifierList, data: D): R =
        visitElement(danglingModifierList, data)

    open fun visitQualifiedAccessExpression(qualifiedAccessExpression: FirQualifiedAccessExpression, data: D): R =
        visitElement(qualifiedAccessExpression, data)

    open fun visitQualifiedErrorAccessExpression(qualifiedErrorAccessExpression: FirQualifiedErrorAccessExpression, data: D): R =
        visitElement(qualifiedErrorAccessExpression, data)

    open fun visitPropertyAccessExpression(propertyAccessExpression: FirPropertyAccessExpression, data: D): R =
        visitElement(propertyAccessExpression, data)

    open fun visitFunctionCall(functionCall: FirFunctionCall, data: D): R =
        visitElement(functionCall, data)

    open fun visitIntegerLiteralOperatorCall(integerLiteralOperatorCall: FirIntegerLiteralOperatorCall, data: D): R =
        visitElement(integerLiteralOperatorCall, data)

    open fun visitImplicitInvokeCall(implicitInvokeCall: FirImplicitInvokeCall, data: D): R =
        visitElement(implicitInvokeCall, data)

    open fun visitDelegatedConstructorCall(delegatedConstructorCall: FirDelegatedConstructorCall, data: D): R =
        visitElement(delegatedConstructorCall, data)

    open fun visitMultiDelegatedConstructorCall(multiDelegatedConstructorCall: FirMultiDelegatedConstructorCall, data: D): R =
        visitElement(multiDelegatedConstructorCall, data)

    open fun visitComponentCall(componentCall: FirComponentCall, data: D): R =
        visitElement(componentCall, data)

    open fun visitCallableReferenceAccess(callableReferenceAccess: FirCallableReferenceAccess, data: D): R =
        visitElement(callableReferenceAccess, data)

    open fun visitThisReceiverExpression(thisReceiverExpression: FirThisReceiverExpression, data: D): R =
        visitElement(thisReceiverExpression, data)

    open fun visitInaccessibleReceiverExpression(inaccessibleReceiverExpression: FirInaccessibleReceiverExpression, data: D): R =
        visitElement(inaccessibleReceiverExpression, data)

    open fun visitSmartCastExpression(smartCastExpression: FirSmartCastExpression, data: D): R =
        visitElement(smartCastExpression, data)

    open fun visitSafeCallExpression(safeCallExpression: FirSafeCallExpression, data: D): R =
        visitElement(safeCallExpression, data)

    open fun visitCheckedSafeCallSubject(checkedSafeCallSubject: FirCheckedSafeCallSubject, data: D): R =
        visitElement(checkedSafeCallSubject, data)

    open fun visitGetClassCall(getClassCall: FirGetClassCall, data: D): R =
        visitElement(getClassCall, data)

    open fun visitWrappedExpression(wrappedExpression: FirWrappedExpression, data: D): R =
        visitElement(wrappedExpression, data)

    open fun visitWrappedArgumentExpression(wrappedArgumentExpression: FirWrappedArgumentExpression, data: D): R =
        visitElement(wrappedArgumentExpression, data)

    open fun visitLambdaArgumentExpression(lambdaArgumentExpression: FirLambdaArgumentExpression, data: D): R =
        visitElement(lambdaArgumentExpression, data)

    open fun visitSpreadArgumentExpression(spreadArgumentExpression: FirSpreadArgumentExpression, data: D): R =
        visitElement(spreadArgumentExpression, data)

    open fun visitNamedArgumentExpression(namedArgumentExpression: FirNamedArgumentExpression, data: D): R =
        visitElement(namedArgumentExpression, data)

    open fun visitVarargArgumentsExpression(varargArgumentsExpression: FirVarargArgumentsExpression, data: D): R =
        visitElement(varargArgumentsExpression, data)

    open fun visitResolvedQualifier(resolvedQualifier: FirResolvedQualifier, data: D): R =
        visitElement(resolvedQualifier, data)

    open fun visitErrorResolvedQualifier(errorResolvedQualifier: FirErrorResolvedQualifier, data: D): R =
        visitElement(errorResolvedQualifier, data)

    open fun visitResolvedReifiedParameterReference(resolvedReifiedParameterReference: FirResolvedReifiedParameterReference, data: D): R =
        visitElement(resolvedReifiedParameterReference, data)

    open fun visitReturnExpression(returnExpression: FirReturnExpression, data: D): R =
        visitElement(returnExpression, data)

    open fun visitStringConcatenationCall(stringConcatenationCall: FirStringConcatenationCall, data: D): R =
        visitElement(stringConcatenationCall, data)

    open fun visitThrowExpression(throwExpression: FirThrowExpression, data: D): R =
        visitElement(throwExpression, data)

    open fun visitVariableAssignment(variableAssignment: FirVariableAssignment, data: D): R =
        visitElement(variableAssignment, data)

    open fun visitWhenSubjectExpression(whenSubjectExpression: FirWhenSubjectExpression, data: D): R =
        visitElement(whenSubjectExpression, data)

    open fun visitDesugaredAssignmentValueReferenceExpression(desugaredAssignmentValueReferenceExpression: FirDesugaredAssignmentValueReferenceExpression, data: D): R =
        visitElement(desugaredAssignmentValueReferenceExpression, data)

    open fun visitWrappedDelegateExpression(wrappedDelegateExpression: FirWrappedDelegateExpression, data: D): R =
        visitElement(wrappedDelegateExpression, data)

    open fun visitEnumEntryDeserializedAccessExpression(enumEntryDeserializedAccessExpression: FirEnumEntryDeserializedAccessExpression, data: D): R =
        visitElement(enumEntryDeserializedAccessExpression, data)

    open fun visitNamedReference(namedReference: FirNamedReference, data: D): R =
        visitElement(namedReference, data)

    open fun visitNamedReferenceWithCandidateBase(namedReferenceWithCandidateBase: FirNamedReferenceWithCandidateBase, data: D): R =
        visitElement(namedReferenceWithCandidateBase, data)

    open fun visitErrorNamedReference(errorNamedReference: FirErrorNamedReference, data: D): R =
        visitElement(errorNamedReference, data)

    open fun visitFromMissingDependenciesNamedReference(fromMissingDependenciesNamedReference: FirFromMissingDependenciesNamedReference, data: D): R =
        visitElement(fromMissingDependenciesNamedReference, data)

    open fun visitSuperReference(superReference: FirSuperReference, data: D): R =
        visitElement(superReference, data)

    open fun visitThisReference(thisReference: FirThisReference, data: D): R =
        visitElement(thisReference, data)

    open fun visitControlFlowGraphReference(controlFlowGraphReference: FirControlFlowGraphReference, data: D): R =
        visitElement(controlFlowGraphReference, data)

    open fun visitResolvedNamedReference(resolvedNamedReference: FirResolvedNamedReference, data: D): R =
        visitElement(resolvedNamedReference, data)

    open fun visitResolvedErrorReference(resolvedErrorReference: FirResolvedErrorReference, data: D): R =
        visitElement(resolvedErrorReference, data)

    open fun visitDelegateFieldReference(delegateFieldReference: FirDelegateFieldReference, data: D): R =
        visitElement(delegateFieldReference, data)

    open fun visitBackingFieldReference(backingFieldReference: FirBackingFieldReference, data: D): R =
        visitElement(backingFieldReference, data)

    open fun visitResolvedCallableReference(resolvedCallableReference: FirResolvedCallableReference, data: D): R =
        visitElement(resolvedCallableReference, data)

    open fun visitResolvedTypeRef(resolvedTypeRef: FirResolvedTypeRef, data: D): R =
        visitElement(resolvedTypeRef, data)

    open fun visitErrorTypeRef(errorTypeRef: FirErrorTypeRef, data: D): R =
        visitElement(errorTypeRef, data)

    open fun visitTypeRefWithNullability(typeRefWithNullability: FirTypeRefWithNullability, data: D): R =
        visitElement(typeRefWithNullability, data)

    open fun visitUserTypeRef(userTypeRef: FirUserTypeRef, data: D): R =
        visitElement(userTypeRef, data)

    open fun visitDynamicTypeRef(dynamicTypeRef: FirDynamicTypeRef, data: D): R =
        visitElement(dynamicTypeRef, data)

    open fun visitFunctionTypeRef(functionTypeRef: FirFunctionTypeRef, data: D): R =
        visitElement(functionTypeRef, data)

    open fun visitIntersectionTypeRef(intersectionTypeRef: FirIntersectionTypeRef, data: D): R =
        visitElement(intersectionTypeRef, data)

    open fun visitImplicitTypeRef(implicitTypeRef: FirImplicitTypeRef, data: D): R =
        visitElement(implicitTypeRef, data)

    open fun visitContractElementDeclaration(contractElementDeclaration: FirContractElementDeclaration, data: D): R =
        visitElement(contractElementDeclaration, data)

    open fun visitEffectDeclaration(effectDeclaration: FirEffectDeclaration, data: D): R =
        visitElement(effectDeclaration, data)

    open fun visitContractDescription(contractDescription: FirContractDescription, data: D): R =
        visitElement(contractDescription, data)

    open fun visitLegacyRawContractDescription(legacyRawContractDescription: FirLegacyRawContractDescription, data: D): R =
        visitElement(legacyRawContractDescription, data)

    open fun visitRawContractDescription(rawContractDescription: FirRawContractDescription, data: D): R =
        visitElement(rawContractDescription, data)

    open fun visitResolvedContractDescription(resolvedContractDescription: FirResolvedContractDescription, data: D): R =
        visitElement(resolvedContractDescription, data)
}
