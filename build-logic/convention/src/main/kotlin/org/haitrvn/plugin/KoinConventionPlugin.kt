package org.haitrvn.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.haitrvn.plugin.convention.libs

class KoinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                libs.findBundle("koin.android.bundle").ifPresent {
                    add("implementation", it)
                }
            }
        }
    }
}