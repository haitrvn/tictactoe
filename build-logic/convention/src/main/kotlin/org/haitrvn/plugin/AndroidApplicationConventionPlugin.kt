package org.haitrvn.plugin

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.haitrvn.plugin.convention.AndroidBuildConfig
import org.haitrvn.plugin.convention.configureKotlinAndroid

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("haitrvn.android.lint")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                packaging {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    }
                }
                defaultConfig.apply {
                    applicationId = AndroidBuildConfig.applicationId
                    targetSdk = AndroidBuildConfig.targetSdkVersion
                    minSdk = AndroidBuildConfig.minSdkVersion
                    compileSdk = AndroidBuildConfig.compileSdkVersion
                    versionCode = AndroidBuildConfig.versionCode
                    versionName = AndroidBuildConfig.versionName
                    testInstrumentationRunner = AndroidBuildConfig.testInstrumentationRunner
                }
                @Suppress("UnstableApiUsage")
                testOptions.animationsDisabled = true
            }
        }
    }
}