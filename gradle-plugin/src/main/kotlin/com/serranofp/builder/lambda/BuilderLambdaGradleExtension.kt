package com.serranofp.builder.lambda

import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property

open class BuilderLambdaGradleExtension(objectFactory: ObjectFactory) {
    val shouldAddRuntimeDependency: Property<Boolean> =
        objectFactory.property(Boolean::class.java).convention(true)
}
