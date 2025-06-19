plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
}

kotlin {
    androidLibrary {
        namespace = "com.haitrvn.navigation"
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

    val xcfName = "navigationKit"
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
                implementation(projects.coreUi)
                implementation(libs.kotlin.stdlib)
                implementation(libs.navigation.compose)
                implementation(libs.kotlinx.serialization.json)
                implementation("org.jetbrains.androidx.navigation:navigation-compose:2.9.0-beta01")
                implementation(libs.koin.core)
                implementation(libs.koin.compose)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
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