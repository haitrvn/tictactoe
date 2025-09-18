import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

@OptIn(ExperimentalKotlinGradlePluginApi::class)
fun KotlinMultiplatformExtension.defaultConfig() {
    compilerOptions.freeCompilerArgs.add("-Xexpect-actual-classes")
    compilerOptions.freeCompilerArgs.add("-Xcontext-parameters")
    applyDefaultHierarchyTemplate()
}