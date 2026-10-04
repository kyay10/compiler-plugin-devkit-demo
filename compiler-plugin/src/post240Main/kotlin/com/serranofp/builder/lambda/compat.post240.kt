package com.serranofp.builder.lambda

import kotlin.collections.getOrPutIfMissing as stdlibGetOrPutIfMissing
import org.jetbrains.kotlin.builtins.functions.FunctionTypeKind
import org.jetbrains.kotlin.fir.SessionHolder
import org.jetbrains.kotlin.fir.types.ConeKotlinType
import org.jetbrains.kotlin.fir.types.typeContext

context(c: SessionHolder)
actual fun function0Type(returnType: ConeKotlinType): ConeKotlinType =
    c.session.typeContext.createSimpleType(
        constructor = c.session.typeContext.getNonReflectFunctionTypeConstructor(0, FunctionTypeKind.Function),
        arguments = listOf(returnType),
        nullable = false,
    )

@ExperimentalStdlibApi
actual inline fun <K, V> MutableMap<K, V>.getOrPutIfMissing(key: K, crossinline defaultValue: () -> V): V =
    stdlibGetOrPutIfMissing(key, defaultValue)