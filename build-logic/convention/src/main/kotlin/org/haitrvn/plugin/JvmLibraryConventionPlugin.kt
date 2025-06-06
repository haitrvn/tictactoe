package org.haitrvn.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.haitrvn.plugin.convention.configureKotlinJvm

class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm")
                apply("haitrvn.android.lint")
            }
            configureKotlinJvm()
        }
    }
}