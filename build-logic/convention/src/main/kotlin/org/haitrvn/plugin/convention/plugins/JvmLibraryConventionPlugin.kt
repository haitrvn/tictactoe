package org.haitrvn.plugin.convention.plugins

import org.haitrvn.plugin.convention.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project

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