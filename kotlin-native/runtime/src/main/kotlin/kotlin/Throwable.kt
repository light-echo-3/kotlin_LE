/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */
@file:OptIn(ExperimentalForeignApi::class)

package kotlin

import kotlin.experimental.ExperimentalNativeApi
import kotlin.native.internal.ExportForCppRuntime
import kotlin.native.internal.ExportTypeInfo
import kotlin.native.internal.GCUnsafeCall
import kotlin.native.internal.NativePtrArray
import kotlin.native.internal.escapeAnalysis.Escapes
import kotlinx.cinterop.ExperimentalForeignApi

/**
 * The base class for all errors and exceptions. Only instances of this class can be thrown or caught.
 *
 * @param message the detail message string.
 * @param cause the cause of this throwable.
 */
@ExportTypeInfo("theThrowableTypeInfo")
public actual open class Throwable
public actual constructor(
        public actual open val message: String?,
        public actual open val cause: Throwable?
) {

    public actual constructor(message: String?) : this(message, null)

    public actual constructor(cause: Throwable?) : this(cause?.toString(), cause)

    public actual constructor() : this(null, null)

    @get:ExportForCppRuntime("Kotlin_Throwable_getStackTrace")
    private val stackTrace: NativePtrArray = getCurrentStackTrace()

    private val stackTraceStrings: Array<String> by lazy {
        getStackTraceStrings(stackTrace)
    }

    /**
     * Returns an array of stack trace strings representing the stack trace
     * pertaining to this throwable.
     */
    // Deprecate this function in favour of KT-57164 when it gets implemented
    @ExperimentalNativeApi
    public fun getStackTrace(): Array<String> = stackTraceStrings

    internal fun getStackTraceAddressesInternal(): List<Long> =
            (0 until stackTrace.size).map { index -> stackTrace[index].toLong() }

    /**
     * Prints the [detailed description][Throwable.stackTraceToString] of this throwable to the standard error output.
     *
     * Note that the format of the output is not stable and may change in the future.
     */
    public fun printStackTrace(): Unit = ExceptionTraceBuilder(this).print()

    internal fun dumpStackTrace(): String = ExceptionTraceBuilder(this).build()

    private class ExceptionTraceBuilder(private val top: Throwable) {
        private val target = StringBuilder()
        private var printOut = false
        private val visited = mutableSetOf<Throwable>()

        fun build(): String {
            top.dumpFullTrace("", "")
            return target.toString()
        }

        fun print() {
            printOut = true
            top.dumpFullTrace("", "")
        }

        private fun StringBuilder.endln() {
            if (printOut) {
                printlnToStdErr(this.toString())
                clear()
            } else {
                appendLine()
            }
        }

        private fun Throwable.dumpFullTrace(indent: String, qualifier: String) {
            this.dumpSelfTrace(indent, qualifier) || return

            var cause = this.cause
            while (cause != null) {
                cause.dumpSelfTrace(indent, "Caused by: ")
                cause = cause.cause
            }
        }

        private fun Throwable.dumpSelfTrace(indent: String, qualifier: String): Boolean {
            if (!visited.add(this)) {
                target.append(indent).append(qualifier).append("[CIRCULAR REFERENCE, SEE ABOVE: ").append(this).append("]").endln()
                return false
            }
            target.append(indent).append(qualifier).append(this).endln()
            // leave 1 common frame to ease matching with the top exception stack
            val commonFrames = (commonStackFrames() - 1).coerceAtLeast(0)
            for (frameIndex in 0 until stackTraceStrings.size - commonFrames) {
                val element = stackTraceStrings[frameIndex]
                target.append(indent).append("    at ").append(element).endln()
            }
            if (commonFrames > 0) {
                target.append(indent).append("    ... and ").append(commonFrames).append(" more common stack frames skipped").endln()
            }
            val suppressed = suppressedExceptionsList
            if (!suppressed.isNullOrEmpty()) {
                val suppressedIndent = indent + "    "
                for (s in suppressed) {
                    s.dumpFullTrace(suppressedIndent, "Suppressed: ")
                }
            }
            return true
        }

        private fun Throwable.commonStackFrames(): Int {
            if (top === this) return 0
            val topStack = top.stackTrace
            val topSize = topStack.size
            val thisStack = this.stackTrace
            val thisSize = thisStack.size
            val maxSize = minOf(topSize, thisSize)
            var frame = 0
            while (frame < maxSize) {
                if (thisStack[thisSize - 1 - frame] != topStack[topSize - 1 - frame]) break
                frame++
            }
            return frame
        }
    }


    /**
     * Returns the short description of this throwable consisting of
     * the exception class name (fully qualified if possible)
     * followed by the exception message if it is not null.
     */
    public override fun toString(): String {
        val kClass = this::class
        val s = kClass.qualifiedName ?: kClass.simpleName ?: "Throwable"
        return if (message != null) s + ": " + message.toString() else s
    }

    internal var suppressedExceptionsList: MutableList<Throwable>? = null
}

@GCUnsafeCall("Kotlin_getCurrentStackTrace")
@Escapes.Nothing
private external fun getCurrentStackTrace(): NativePtrArray

@GCUnsafeCall("Kotlin_getStackTraceStrings")
@Escapes.Nothing
private external fun getStackTraceStrings(stackTrace: NativePtrArray): Array<String>

/**
 * Returns the detailed description of this throwable with its stack trace.
 *
 * The detailed description includes:
 * - the short description (see [Throwable.toString]) of this throwable;
 * - the complete stack trace;
 * - detailed descriptions of the exceptions that were [suppressed][suppressedExceptions] in order to deliver this exception;
 * - the detailed description of each throwable in the [Throwable.cause] chain.
 *
 * Note that the description format is not stable and may change in the future.
 */
@SinceKotlin("1.4")
public actual fun Throwable.stackTraceToString(): String = dumpStackTrace()

/**
 * Prints the [detailed description][Throwable.stackTraceToString] of this throwable to the standard error output.
 *
 * Note that the format of the output is not stable and may change in the future.
 */
@SinceKotlin("1.4")
@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
@kotlin.internal.InlineOnly
public actual inline fun Throwable.printStackTrace(): Unit = printStackTrace()

/**
 * Adds the specified exception to the list of exceptions that were
 * suppressed in order to deliver this exception.
 */
@SinceKotlin("1.4")
public actual fun Throwable.addSuppressed(exception: Throwable) {
    if (this !== exception) {
        val suppressed = suppressedExceptionsList
        when {
            suppressed == null -> suppressedExceptionsList = mutableListOf<Throwable>(exception)
            else -> suppressed.add(exception)
        }
    }
}

/**
 * Returns a list of all exceptions that were suppressed in order to deliver this exception.
 */
@SinceKotlin("1.4")
public actual val Throwable.suppressedExceptions: List<Throwable> get() {
    return this.suppressedExceptionsList ?: emptyList()
}
