@file:OptIn(ExperimentalContracts::class)

package com.serranofp.builder.lambda

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
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
    ) as ConeKotlinType

@ExperimentalStdlibApi
actual inline fun <K, V> MutableMap<K, V>.getOrPutIfMissing(key: K, crossinline defaultValue: () -> V): V {
    contract {
        callsInPlace(defaultValue, InvocationKind.AT_MOST_ONCE)
    }
    val value = get(key)
    return if (value == null && !containsKey(key)) {
        val answer = defaultValue()
        put(key, answer)
        answer
    } else {
        @Suppress("UNCHECKED_CAST")
        value as V
    }
}