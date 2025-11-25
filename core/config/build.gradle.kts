@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    id(libs.plugins.multiplatform.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.compose.get().pluginId)
    alias(libs.plugins.composecompiler)
    alias(libs.plugins.buildKonfig)
}

kotlin {
    allTargets()
    defaultConfig()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.core)
                implementation(libs.kotlin.stdlib)
                implementation(compose.runtime)
            }
        }
    }
}

configureLibraryAndroidTarget()

buildkonfig {
    packageName = "com.haitrvn.cookapp"
    defaultConfigs {
    }
}