@file:OptIn(ExperimentalWasmDsl::class)

import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.buildKonfig)
}

kotlin {

    androidLibrary {
        namespace = "com.haitrvn.core"
        compileSdk = 35
        minSdk = 24

        withHostTestBuilder {
        }

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }
    jvm()

    wasmJs {
        browser()
    }
    val xcfName = "corekit"

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = xcfName
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kermit)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.kotlinx.coroutines.test)
            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.runner)
                implementation(libs.androidx.core)
                implementation(libs.androidx.junit)
            }
        }
    }
}

buildkonfig {
    packageName = "com.haitrvn.cook"

    // default config is required
    defaultConfigs {
        buildConfigField(STRING, "name", "value")
    }
    // flavor is passed as a first argument of defaultConfigs
    defaultConfigs("dev") {
        buildConfigField(STRING, "name", "devValue")
    }

    targetConfigs {
        create("android") {
            buildConfigField(STRING, "name2", "value2")
        }

        create("ios") {
            buildConfigField(STRING, "name", "valueIos")
        }
    }
    // flavor is passed as a first argument of targetConfigs
    targetConfigs("dev") {
        create("ios") {
            buildConfigField(STRING, "name", "devValueIos")
        }
    }
}