import org.jetbrains.kotlin.compiler.plugin.devkit.ProjectOrGav

plugins {
    pluginDevKit("gradle-plugin")
}

pluginDevKit {
    includedBuildProjects.addAll("gradle-plugin", "support-lib")
    compilerPlugin = ProjectOrGav.LocalProject(project(":builder-lambda-compiler-plugin").isolated)
}
