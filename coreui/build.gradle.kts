@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    id(libs.plugins.multiplatform.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.compose.get().pluginId)
    alias(libs.plugins.composecompiler)
}

kotlin {
    allTargets()
    defaultConfig()
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.core)
                implementation(libs.kotlin.stdlib)
                implementation(libs.jetbrains.compose.runtime)
                implementation(libs.jetbrains.compose.foundation)
                implementation(libs.jetbrains.compose.material3)
                implementation(libs.jetbrains.compose.components.resources)
                implementation(libs.jetbrains.compose.components.uiToolingPreview)
                implementation(libs.androidx.lifecycle.runtime.compose)
                implementation(libs.koin.compose)
                implementation(libs.coil.core)
                implementation(libs.coil.compose)
                implementation(libs.coil.network.core)
                implementation(libs.coil.network.ktor)
                implementation(libs.coil.network.cache.control)
                implementation(libs.ktor.client.core)

                api("dev.chrisbanes.haze:haze:1.6.10")
                api("dev.chrisbanes.haze:haze-materials:1.6.10")
                implementation(libs.kotlinx.collections.immutable)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
            implementation(libs.androidx.ui.tooling)
        }
        jvmMain.dependencies {
            implementation(libs.ktor.client.okhttp)
            implementation("org.jetbrains.compose.ui:ui-tooling-preview:1.8.0")
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
        wasmJsMain.dependencies {
            implementation("io.ktor:ktor-client-js:3.2.1")
        }
    }
}

configureLibraryAndroidTarget()

compose.resources {
    publicResClass = false
    packageOfResClass = "cookapp.resources.core.ui"
    generateResClass = auto
}