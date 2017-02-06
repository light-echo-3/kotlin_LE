package org.jetbrains.kotlin.backend.konan.ir

import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.ir.*
import org.jetbrains.kotlin.ir.util.DumpIrTreeVisitor
import org.jetbrains.kotlin.ir.declarations.*
import org.jetbrains.kotlin.ir.expressions.*
import java.io.StringWriter


/**
 * Binds the arguments explicitly represented in the IR to the parameters of the accessed function.
 * The arguments are to be evaluated in the same order as they appear in the resulting list.
 */
internal fun IrMemberAccessExpression.getArguments(): List<Pair<ParameterDescriptor, IrExpression>> {
    val res = mutableListOf<Pair<ParameterDescriptor, IrExpression>>()
    val descriptor = descriptor

    // TODO: ensure the order below corresponds to the one defined in Kotlin specs.

    dispatchReceiver?.let {
        res += (descriptor.dispatchReceiverParameter!! to it)
    }

    extensionReceiver?.let {
        res += (descriptor.extensionReceiverParameter!! to it)
    }

    descriptor.valueParameters.forEach {
        val arg = getValueArgument(it.index)
        if (arg != null) {
            res += (it to arg)
        }
    }

    return res
}

/**
 * Sets arguments that are specified by given mapping of parameters.
 */
internal fun IrMemberAccessExpression.addArguments(args: Map<ParameterDescriptor, IrExpression>) {
    descriptor.dispatchReceiverParameter?.let {
        val arg = args[it]
        if (arg != null) {
            this.dispatchReceiver = arg
        }
    }

    descriptor.extensionReceiverParameter?.let {
        val arg = args[it]
        if (arg != null) {
            this.extensionReceiver = arg
        }
    }

    descriptor.valueParameters.forEach {
        val arg = args[it]
        if (arg != null) {
            this.putValueArgument(it.index, arg)
        }
    }
}

internal fun IrMemberAccessExpression.addArguments(args: List<Pair<ParameterDescriptor, IrExpression>>) =
        this.addArguments(args.toMap())

internal fun IrExpression.isNullConst() = this is IrConst<*> && this.kind == IrConstKind.Null

fun ir2string(ir: IrElement?): String = ir2stringWhole(ir).takeWhile { it != '\n' }

fun ir2stringWhole(ir: IrElement?): String {
  val strWriter = StringWriter()

  ir?.accept(DumpIrTreeVisitor(strWriter), "")
  return strWriter.toString()
}

