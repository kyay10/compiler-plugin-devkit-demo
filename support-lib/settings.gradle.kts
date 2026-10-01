pluginManagement {
    includeBuild("../gradle-plugin")
    includeBuild("../build-logic")
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://packages.jetbrains.team/maven/p/compiler-plugin-dev-kit/eap")
    }
}

plugins { id("devkit-included") }

rootProject.name = "builder-lambda-support-lib"
