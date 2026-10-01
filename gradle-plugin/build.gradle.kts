import org.jetbrains.kotlin.compiler.plugin.devkit.ProjectOrGav

plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    pluginDevKit("gradle-plugin")
}

pluginDevKit {
    companionLibrary("builder-lambda-support-lib")
    compilerPlugin = ProjectOrGav.Sibling("builder-lambda-compiler-plugin")
}

gradlePlugin {
    website = "https://serranofp.com"
    vcsUrl = "https://github.com/serras/builder-lambda"

    plugins {
        create("BuilderLambdaPlugin") {
            id = "com.serranofp.builder.lambda"
            displayName = "Builder Lambda Kotlin plug-in"
            description = "Java builders, the way Kotliners like them"
            implementationClass = "com.serranofp.builder.lambda.BuilderLambdaGradlePlugin"
            tags = setOf("builder", "kotlin")
        }
    }
}
