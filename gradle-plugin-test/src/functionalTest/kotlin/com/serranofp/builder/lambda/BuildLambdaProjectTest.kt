package com.serranofp.builder.lambda

import com.autonomousapps.kit.GradleBuilder.build
import com.autonomousapps.kit.gradle.Dependency.Companion.implementation
import com.autonomousapps.kit.gradle.Plugin
import org.intellij.lang.annotations.Language
import org.jetbrains.kotlin.compiler.plugin.devkit.test.TEST_COMPILER_VERSION
import org.jetbrains.kotlin.compiler.plugin.devkit.test.assertOutputContains
import org.junit.Test

class BuildLambdaProjectTest {
    @Test
    fun testHasAnnotationsDependency() {
        val project =
            object : BuildLambdaProject() {
                override fun sources() = listOf(source(simpleFile))
            }
                .gradleProject
        val result = build(project.rootDir, "dependencies", "--configuration", "compileClasspath")
        result.assertOutputContains(
            "com.serranofp:builder-lambda-support-lib"
        )
    }

    @Test
    fun testCompiles() {
        val project =
            object : BuildLambdaProject() {
                override fun buildGradleProject() = multiModuleProject {
                    root {
                        plugins(Plugin("org.jetbrains.kotlin.plugin.serialization", "$TEST_COMPILER_VERSION"))
                        dependencies(
                            implementation("org.springframework.ai:spring-ai-ollama:2.0.1"),
                            implementation("ai.djl.fasttext:fasttext-engine:0.38.0")
                        )
                        sources(listOf(source(simpleFile)))
                    }
                }
            }
                .gradleProject
        build(project.rootDir, "build")
    }
}

@Language("kotlin")
private val simpleFile =
    """
    import org.springframework.ai.ollama.api.*
    import ai.djl.fasttext.*
    import kotlin.io.path.Path
    
    fun test() {
        val options = build<OllamaChatOptions, *> {
            model(OllamaModel.LLAMA3_1)
            temperature = 0.4
        }
        val text = build<FtTrainingConfig, *> {
            modelName = "hello"
            outputDir = Path("./output")
            threads = 4
        }
    }
    """
        .trimIndent()
