@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    id(libs.plugins.multiplatform.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.compose.get().pluginId)
    alias(libs.plugins.composecompiler)
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xcontext-parameters")
    }
    allTargets()
    defaultConfig()
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.core)
                implementation(libs.kotlin.stdlib)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(libs.androidx.lifecycle.runtime.compose)
                implementation(libs.koin.compose)
                implementation(libs.coil.core)
                implementation(libs.coil.compose)
                implementation(libs.coil.network.core)
                implementation(libs.coil.network.ktor)
                implementation(libs.coil.network.cache.control)
                implementation(libs.ktor.client.core)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
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
    publicResClass = true
    packageOfResClass = "cookapp.resources.core.ui"
    generateResClass = auto
}