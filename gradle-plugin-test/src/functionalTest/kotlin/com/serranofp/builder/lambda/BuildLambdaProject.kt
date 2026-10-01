package com.serranofp.builder.lambda

import com.autonomousapps.kit.gradle.Plugin
import com.autonomousapps.kit.gradle.Repositories
import com.autonomousapps.kit.gradle.Repository
import org.jetbrains.kotlin.compiler.plugin.devkit.test.AbstractDevKitGradleProject
import org.jetbrains.kotlin.compiler.plugin.devkit.test.pluginUnderTestVersion

open class BuildLambdaProject(multiplatform: Boolean = false) :
    AbstractDevKitGradleProject(multiplatform = multiplatform) {
    override val defaultImports: List<String>
        get() = listOf("com.serranofp.builder.lambda.build")

    override val pluginUnderTest: Plugin
        get() = Plugin("com.serranofp.builder.lambda", pluginUnderTestVersion)

    override fun repositories(defaults: List<Repository>): Repositories {
        return super.repositories(defaults + Repository.MAVEN_LOCAL)
    }
}
