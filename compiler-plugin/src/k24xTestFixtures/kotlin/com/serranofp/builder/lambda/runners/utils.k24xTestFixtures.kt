package com.serranofp.builder.lambda.runners

import org.jetbrains.kotlin.config.LanguageFeature
import org.jetbrains.kotlin.test.builders.RegisteredDirectivesBuilder
import org.jetbrains.kotlin.test.directives.LanguageSettingsDirectives.LANGUAGE

actual fun RegisteredDirectivesBuilder.enableCompanionBlocksAndExtensions() {
    LANGUAGE with "+${LanguageFeature.CompanionBlocksAndExtensions}"
}