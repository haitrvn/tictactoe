import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    id(libs.plugins.multiplatform.get().pluginId) apply false
    id(libs.plugins.android.library.get().pluginId) apply false
    id(libs.plugins.compose.get().pluginId) apply false
    id(libs.plugins.android.application.get().pluginId) apply false

    alias(libs.plugins.composecompiler) apply false
    alias(libs.plugins.hotReload) apply false
    alias(libs.plugins.kotlinx.serialization) apply false
    alias(libs.plugins.room) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.buildKonfig) apply false
}

subprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        compilerOptions {
            if (project.findProperty("composeCompilerReports") == "true") {
                freeCompilerArgs.addAll( listOf(
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=${project.layout.projectDirectory}/build/compose_compiler"
                ))
            }
            if (project.findProperty("composeCompilerMetrics") == "true") {
                freeCompilerArgs.addAll( listOf(
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=${project.layout.projectDirectory}/build/compose_compiler"
                ))
            }
        }
    }
}