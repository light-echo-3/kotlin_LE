// DONT_TARGET_EXACT_BACKEND: WASM
// WASM_MUTE_REASON: UNSUPPORTED_JS_INTEROP
package foo

class A

fun box(): String {
    assertEquals("number", jsTypeOf(1))
    assertEquals("number", jsTypeOf(1.2))
    assertEquals("boolean", jsTypeOf(true))
    assertEquals("string", jsTypeOf("sss"))
    assertEquals("object", jsTypeOf(null))
    assertEquals("undefined", jsTypeOf(undefined))
    assertEquals("object", jsTypeOf(object {}))
    assertEquals("object", jsTypeOf(A()))

    return "OK"
}