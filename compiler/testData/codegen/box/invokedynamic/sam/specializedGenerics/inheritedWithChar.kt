// TARGET_BACKEND: JVM
// JVM_TARGET: 1.8
// SAM_CONVERSIONS: INDY

// CHECK_BYTECODE_TEXT
// 1 java/lang/invoke/LambdaMetafactory

fun interface GenericToAny<T> {
    fun invoke(x: T): Any
}

fun interface GenericCharToAny : GenericToAny<Char>

fun withK(fn: GenericCharToAny) = fn.invoke('K').toString()

fun box(): String =
    withK { "O" + it }
