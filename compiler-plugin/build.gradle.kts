plugins {
    pluginDevKit("compiler-plugin")
    alias(libs.plugins.gradle.maven.publish)
}

pluginDevKit {
    componentRegistrar =
        "com.serranofp.builder.lambda.BuilderLambdaComponentRegistrar"
    commandLineProcessor =
        "com.serranofp.builder.lambda.BuilderLambdaCommandLineProcessor"
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xcollection-literals")
        freeCompilerArgs.add("-Xname-based-destructuring=complete")
    }
}
