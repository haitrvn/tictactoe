@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    id(libs.plugins.multiplatform.get().pluginId)
    id(libs.plugins.compose.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.composecompiler)
}

kotlin {
    allTargets()
    defaultConfig()

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.navigation)
                implementation(projects.domain)
                implementation(projects.coreui)
                implementation(projects.core)
                implementation(libs.kotlin.stdlib)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(libs.androidx.lifecycle.runtime.compose)
                implementation(libs.koin.compose)
                implementation("io.insert-koin:koin-compose-viewmodel:4.0.4") {
                    exclude(group = "org.jetbrains.androidx.core", module = "core-bundle")
                }
                implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.9.0")
                implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.4.0")
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        jvmMain.dependencies {
            implementation("org.jetbrains.compose.ui:ui-tooling-preview:1.8.0")
        }

    }
}

configureLibraryAndroidTarget()

compose.resources {
    publicResClass = true
    packageOfResClass = "cookapp.resources.splash"
    generateResClass = auto
}