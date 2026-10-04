import org.jetbrains.kotlin.compiler.plugin.devkit.ProjectOrGav
import org.jetbrains.kotlin.tooling.core.KotlinToolingVersion

plugins {
    pluginDevKit("gradle-plugin")
}

pluginDevKit {
    includedBuildProjects.addAll("gradle-plugin", "support-lib")
    compilerPlugin = ProjectOrGav.LocalProject(project(":builder-lambda-compiler-plugin").isolated)
    companionLibrariesKotlinVersion = KotlinToolingVersion(libs.versions.kotlinMin.get())
}
