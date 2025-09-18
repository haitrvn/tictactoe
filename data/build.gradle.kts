@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    id(libs.plugins.multiplatform.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
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
                implementation(projects.domain)
                implementation(libs.kotlin.stdlib)
                implementation(libs.koin.core)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
        androidMain.dependencies {
            implementation(projects.domain)
        }
    }
}

configureLibraryAndroidTarget()