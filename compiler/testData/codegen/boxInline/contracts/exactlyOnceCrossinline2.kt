// OPT_IN: kotlin.contracts.ExperimentalContracts
// JVM_ABI_K1_K2_DIFF: KT-62845

// FILE: 1.kt
package test

import kotlin.contracts.*

class A {
    var res = "FAIL"

    fun foo() {
        bar {
            res = "OK"
        }
    }

    inline fun bar(crossinline not_exactly_once: () -> Unit) {
        baz {
            not_exactly_once()
        }
    }
}

inline fun baz(crossinline exactly_once: () -> Unit) {
    contract {
        callsInPlace(exactly_once, InvocationKind.EXACTLY_ONCE)
    };

    { exactly_once() }.let { it() }
}

// FILE: 2.kt

import test.*

fun box(): String {
    val a = A()
    a.foo()
    return a.res
}
