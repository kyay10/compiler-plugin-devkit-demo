package com.serranofp.builder.lambda

import org.jetbrains.kotlin.fir.SessionHolder
import org.jetbrains.kotlin.fir.types.ConeKotlinType

context(c: SessionHolder)
expect fun function0Type(returnType: ConeKotlinType): ConeKotlinType

@ExperimentalStdlibApi
expect inline fun <K, V> MutableMap<K, V>.getOrPutIfMissing(key: K, crossinline defaultValue: () -> V): V
