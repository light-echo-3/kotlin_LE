// FIR_IDENTICAL
// DIAGNOSTICS: +ENUM_CLASS_IN_EXTERNAL_DECLARATION_WARNING
external interface I {
    interface J

    class <!NESTED_CLASS_IN_EXTERNAL_INTERFACE!>C<!>

    <!NESTED_CLASS_IN_EXTERNAL_INTERFACE!>object O<!>

    enum class <!ENUM_CLASS_IN_EXTERNAL_DECLARATION_WARNING, NESTED_CLASS_IN_EXTERNAL_INTERFACE!>E<!>

    companion object
}

external interface I2 {
    companion <!NAMED_COMPANION_IN_EXTERNAL_INTERFACE!>object Named<!>
}
