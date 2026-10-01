pluginManagement {
    includeBuild("./build-logic")
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://packages.jetbrains.team/maven/p/compiler-plugin-dev-kit/eap")
    }
}

plugins { id("devkit") }

pluginDevKit {
    includeBuildWithChecks("gradle-plugin")
    includeBuildWithChecks("support-lib")
    companionLibrary("builder-lambda-support-lib")
}

rootProject.name = "compiler-plugin-devkit-demo"

include("builder-lambda-compiler-plugin")
project(":builder-lambda-compiler-plugin").projectDir = file("compiler-plugin")

include("gradle-plugin-test")

includeBuild(".")
