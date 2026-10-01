package com.serranofp.builder.lambda

import com.serranofp.builder.lambda.runners.AbstractJvmBoxTest
import com.serranofp.builder.lambda.runners.AbstractJvmDiagnosticTest
import org.jetbrains.kotlin.compiler.plugin.devkit.DevKitTestGroup
import org.jetbrains.kotlin.compiler.plugin.devkit.generateDevKitTestsWithJUnit5

fun main() = generateDevKitTestsWithJUnit5 {
    testClass<AbstractJvmDiagnosticTest> {
        model("diagnostics")
    }

    testClass<AbstractJvmBoxTest> {
        model("box")
    }
    addExtraTests()
}

expect fun DevKitTestGroup.addExtraTests()
