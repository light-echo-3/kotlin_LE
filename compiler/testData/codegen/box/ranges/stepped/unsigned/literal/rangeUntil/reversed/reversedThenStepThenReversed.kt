// Auto-generated by GenerateSteppedRangesCodegenTestData. Do not edit!
// WITH_STDLIB
// DONT_TARGET_EXACT_BACKEND: JVM
// LANGUAGE: +RangeUntilOperator
@file:OptIn(ExperimentalStdlibApi::class)
import kotlin.test.*

fun box(): String {
    val uintList = mutableListOf<UInt>()
    for (i in ((1u..<9u).reversed() step 2).reversed()) {
        uintList += i
    }
    assertEquals(listOf(2u, 4u, 6u, 8u), uintList)

    val ulongList = mutableListOf<ULong>()
    for (i in ((1uL..<9uL).reversed() step 2L).reversed()) {
        ulongList += i
    }
    assertEquals(listOf(2uL, 4uL, 6uL, 8uL), ulongList)

    return "OK"
}