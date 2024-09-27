package foo

@JsExport
object A {
    private val foo: Int
        get() = 23

    fun bar(): Int {
        return foo
    }
}

fun box(): String {
    var result = A.bar()
    if (result != 23) return "failed: ${result}"
    return "OK"
}
