package com.serranofp.builder.lambda.runners

import org.jetbrains.kotlin.compiler.plugin.devkit.runners.DevKitJsBoxTest
import org.jetbrains.kotlin.test.builders.TestConfigurationBuilder

open class AbstractJsBoxTest : DevKitJsBoxTest(TestConfigurationBuilder::config)
