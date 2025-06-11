package org.haitrvn.plugin

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.haitrvn.plugin.convention.AndroidBuildConfig
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KmpFeature : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.multiplatform")
            }

            extensions.configure<LibraryExtension> {
                compileSdk = AndroidBuildConfig.compileSdkVersion
                defaultConfig.minSdk = AndroidBuildConfig.minSdkVersion
                defaultConfig.targetSdk = AndroidBuildConfig.targetSdkVersion
                testOptions.animationsDisabled = true
            }

            extensions.configure<KotlinMultiplatformExtension> {
                androidTarget()

                iosX64()
                iosArm64()
                iosSimulatorArm64()
                applyDefaultHierarchyTemplate()

                sourceSets.commonMain {
                    dependencies {
                        libs.findLibrary("koin.core").ifPresent {
                            implementation(it)
                        }
                    }
                }
            }
        }
    }
}