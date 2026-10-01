package com.serranofp.builder.lambda

import com.serranofp.builder.lambda.runners.AbstractJsBoxTest
import com.serranofp.builder.lambda.runners.AbstractJsDiagnosticTest
import org.jetbrains.kotlin.compiler.plugin.devkit.DevKitTestGroup

actual fun DevKitTestGroup.addExtraTests() {
    testClass<AbstractJsDiagnosticTest> {
        model("diagnostics")
    }

    testClass<AbstractJsBoxTest> {
        model("box")
    }
}
