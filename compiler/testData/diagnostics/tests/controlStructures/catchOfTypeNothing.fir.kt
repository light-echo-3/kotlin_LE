fun foo() {
    try {
        throw Exception()
    } catch (<!THROWABLE_TYPE_MISMATCH!>x: Nothing<!>) {
    }

    try {
        throw Exception()
    } catch (<!THROWABLE_TYPE_MISMATCH!>x: Nothing?<!>) {
    }
}
