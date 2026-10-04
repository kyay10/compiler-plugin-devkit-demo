package com.serranofp.builder.lambda.runners

import com.serranofp.builder.lambda.BuilderLambdaComponentRegistrar
import org.jetbrains.kotlin.compiler.plugin.devkit.services.configurePlugin
import org.jetbrains.kotlin.test.builders.RegisteredDirectivesBuilder
import org.jetbrains.kotlin.test.builders.TestConfigurationBuilder
import org.jetbrains.kotlin.test.directives.FirDiagnosticsDirectives

fun TestConfigurationBuilder.config() {
    configurePlugin(BuilderLambdaComponentRegistrar())
    defaultDirectives {
        -FirDiagnosticsDirectives.FIR_DUMP
        enableCompanionBlocksAndExtensions()
    }
}

expect fun RegisteredDirectivesBuilder.enableCompanionBlocksAndExtensions()
