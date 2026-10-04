import org.jetbrains.kotlin.tooling.core.KotlinToolingVersion
import org.jetbrains.kotlin.tooling.core.toKotlinVersion

plugins {
    pluginDevKit("compiler-plugin")
    alias(libs.plugins.gradle.maven.publish)
}

pluginDevKit {
    versionHierarchy {
        split("2.4.0")
        splitDev(2, 5)
        groupVersions("k24x") { it.toKotlinVersion() < KotlinVersion(2, 5) && it >= KotlinToolingVersion("2.4.0") }
    }
    componentRegistrar =
        "com.serranofp.builder.lambda.BuilderLambdaComponentRegistrar"
    commandLineProcessor =
        "com.serranofp.builder.lambda.BuilderLambdaCommandLineProcessor"
    preferredVersionForSharedSourceSetsInIde = KotlinToolingVersion("2.3.21")
    companionLibrariesKotlinVersion = KotlinToolingVersion(libs.versions.kotlinMin.get())
    testAgainst.configureEach {
        if (version < KotlinToolingVersion("2.4.0")) testTask { enabled = false }
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xcollection-literals")
        freeCompilerArgs.add("-Xname-based-destructuring=complete")
    }
}
