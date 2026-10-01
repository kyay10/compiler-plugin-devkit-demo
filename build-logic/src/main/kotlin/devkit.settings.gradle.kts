plugins {
    kotlin("compiler.plugin.devkit")
}

pluginDevKit {
    /*cliVersions("2.3.20", betaAndRc = BetaAndRc.LATEST)
    ideaVersions("261", includeRc = true, includeEap = true)
    useLatestDev()*/
    pluginPackage("com.serranofp.builder.lambda")
}

gradle.lifecycle.beforeProject {
    group = "com.serranofp"
    version = (property("version") as? String).let { version ->
        if (version == null || version == "unspecified") "0.1.0-SNAPSHOT"
        else version
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("https://packages.jetbrains.team/maven/p/compiler-plugin-dev-kit/eap")
    }
}
