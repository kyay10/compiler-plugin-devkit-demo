import org.jetbrains.kotlin.tooling.core.KotlinToolingVersion

plugins {
    pluginDevKit("compiler-plugin")
    alias(libs.plugins.gradle.maven.publish)
}

pluginDevKit {
    versionHierarchy {
        split("2.4.0")
    }
    componentRegistrar =
        "com.serranofp.builder.lambda.BuilderLambdaComponentRegistrar"
    commandLineProcessor =
        "com.serranofp.builder.lambda.BuilderLambdaCommandLineProcessor"
    preferredVersionForSharedSourceSetsInIde = KotlinToolingVersion("2.3.21")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xcollection-literals")
        freeCompilerArgs.add("-Xname-based-destructuring=complete")
    }
}
