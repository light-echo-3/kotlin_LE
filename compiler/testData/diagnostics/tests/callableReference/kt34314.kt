// DIAGNOSTICS: -UNUSED_VARIABLE

fun main() {
    val x = <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>run<!> { <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>::run<!> } // no error
}
