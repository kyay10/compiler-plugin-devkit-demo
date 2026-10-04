package com.serranofp.builder.lambda.runners

import org.jetbrains.kotlin.compiler.plugin.devkit.runners.DevKitJvmDiagnosticTest
import org.jetbrains.kotlin.test.builders.TestConfigurationBuilder
import org.jetbrains.kotlin.test.directives.TestPhaseDirectives.RUN_PIPELINE_TILL
import org.jetbrains.kotlin.test.services.TestPhase

open class AbstractJvmDiagnosticTest : DevKitJvmDiagnosticTest(TestConfigurationBuilder::config, {
    defaultDirectives { RUN_PIPELINE_TILL with TestPhase.entries.last() }
})
