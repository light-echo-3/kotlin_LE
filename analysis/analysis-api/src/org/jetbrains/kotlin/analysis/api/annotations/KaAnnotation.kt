/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.annotations

import org.jetbrains.kotlin.analysis.api.lifetime.KaLifetimeOwner
import org.jetbrains.kotlin.analysis.api.lifetime.withValidityAssertion
import org.jetbrains.kotlin.analysis.api.symbols.KaConstructorSymbol
import org.jetbrains.kotlin.analysis.api.symbols.pointers.KaSymbolPointer
import org.jetbrains.kotlin.descriptors.annotations.AnnotationUseSiteTarget
import org.jetbrains.kotlin.name.ClassId
import org.jetbrains.kotlin.psi.KtCallElement

/**
 * Application of annotation to some declaration, type, or as argument inside another annotation.
 *
 * Some examples:
 * - For declarations: `@Deprecated("Should not be used") fun foo(){}`
 * - For types: `fun foo(x: List<@A Int>){}`
 * - Inside another annotation (`B` is annotation here): `@A(B()) fun foo(){}
 */
public interface KaAnnotation : KaLifetimeOwner {
    /**
     * The [ClassId] of applied annotation. [ClassId] is a fully qualified name on annotation class.
     */
    public val classId: ClassId?

    /**
     * [com.intellij.psi.PsiElement] which was used to apply annotation to declaration/type.
     *
     * Present only for declarations from sources. For declarations from other places (libraries, stdlib) it's `null`
     */
    public val psi: KtCallElement?

    /**
     * [AnnotationUseSiteTarget] to which annotation was applied. May be not-null only for annotation applications for declarations.
     *
     * See more details in [Kotlin Documentation](https://kotlinlang.org/docs/annotations.html#annotation-use-site-targets) for more information about annotation targets.
     */
    public val useSiteTarget: AnnotationUseSiteTarget?

    /**
     * This property can be used to optimize some argument processing logic.
     * For example, if you have [KaAnnotationApplicationInfo] from [KaAnnotated.annotationInfos] and [hasArguments] is **false**,
     * then you can avoid [KaAnnotated.annotationsByClassId] call,
     * because effectively you already have all necessary information in [KaAnnotationApplicationInfo]
     */
    @Deprecated("Use 'arguments.isNotEmpty()' instead.", replaceWith = ReplaceWith("arguments.isNotEmpty()"))
    public val hasArguments: Boolean
        get() = arguments.isNotEmpty()

    @Deprecated("Use 'arguments.isNotEmpty()' instead.", replaceWith = ReplaceWith("arguments.isNotEmpty()"))
    public val isCallWithArguments: Boolean
        get() = arguments.isNotEmpty()

    /**
     * An index of the annotation in an owner. `null` when annotation is used as an argument of other annotations
     */
    @Deprecated("The API is not reliable and will be removed soon. Implement on the use site if needed.")
    public val index: Int?
        get() = null

    /**
     * A list of explicitly provided annotation values.
     */
    public val arguments: List<KaNamedAnnotationValue>

    /**
     * An annotation constructor symbol.
     */
    public val constructorSymbol: KaConstructorSymbol?

    @Deprecated("Use 'constructorSymbol' instead.")
    public val constructorSymbolPointer: KaSymbolPointer<KaConstructorSymbol>?
        get() = withValidityAssertion { constructorSymbol?.createPointer() }
}

@Deprecated("Use 'KaAnnotation' instead.", ReplaceWith("KaAnnotation"))
public typealias KtAnnotationApplication = KaAnnotation

@Deprecated("Use 'KaAnnotation' instead.", ReplaceWith("KaAnnotation"))
public typealias KaAnnotationApplication = KaAnnotation

@Deprecated("Use 'KaAnnotation' instead.", ReplaceWith("KaAnnotation"))
public typealias KaAnnotationApplicationInfo = KaAnnotation

@Deprecated("Use 'KaAnnotation' instead.", ReplaceWith("KaAnnotation"))
public typealias KtAnnotationApplicationInfo = KaAnnotation

@Deprecated("Use 'KaAnnotation' instead.", ReplaceWith("KaAnnotation"))
public typealias KaAnnotationApplicationWithArgumentsInfo = KaAnnotation

@Deprecated("Use 'KaAnnotation' instead.", ReplaceWith("KaAnnotation"))
public typealias KtAnnotationApplicationWithArgumentsInfo = KaAnnotation