// Auto-generated by GenerateSteppedRangesCodegenTestData. Do not edit!
// WITH_STDLIB
// DONT_TARGET_EXACT_BACKEND: JVM
// LANGUAGE: +RangeUntilOperator
@file:OptIn(ExperimentalStdlibApi::class)
import kotlin.test.*

fun box(): String {
    assertFailsWith<IllegalArgumentException> {
        val uintProgression = 1u..<8u
        for (i in uintProgression step 0) {
        }
    }

    assertFailsWith<IllegalArgumentException> {
        val ulongProgression = 1uL..<8uL
        for (i in ulongProgression step 0L) {
        }
    }

    return "OK"
}