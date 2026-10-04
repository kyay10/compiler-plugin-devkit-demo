package com.serranofp.builder.lambda.runners

import org.jetbrains.kotlin.compiler.plugin.devkit.runners.DevKitJvmBoxTest
import org.jetbrains.kotlin.test.builders.TestConfigurationBuilder

open class AbstractJvmBoxTest : DevKitJvmBoxTest(TestConfigurationBuilder::config)
