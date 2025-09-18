import org.gradle.kotlin.dsl.assign
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

fun KotlinMultiplatformExtension.iosTargets() {
    iosX64()
    iosArm64()
    iosSimulatorArm64()
}

fun KotlinMultiplatformExtension.configuredJvmTarget(jvmTarget: JvmTarget = JvmTarget.JVM_1_8) {
    jvm {
        compilerOptions.jvmTarget = jvmTarget
    }
}

fun KotlinMultiplatformExtension.configuredAndroidTarget(jvmTarget: JvmTarget = JvmTarget.JVM_1_8) {
    androidTarget {
        compilerOptions.jvmTarget = jvmTarget
    }
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
fun KotlinMultiplatformExtension.jvmTargets(jvmTarget: JvmTarget = JvmTarget.JVM_1_8) {
    configuredAndroidTarget(jvmTarget)
    configuredJvmTarget(jvmTarget)
}

@OptIn(ExperimentalWasmDsl::class)
fun KotlinMultiplatformExtension.wasmJsTarget() {
    wasmJs {
        browser {
            testTask {
                enabled = false
            }
        }
        nodejs {
            testTask {
                enabled = false
            }
        }
    }
}

@OptIn(ExperimentalWasmDsl::class)
fun KotlinMultiplatformExtension.allTargets() {
    jvmTargets()
    iosTargets()
    wasmJsTarget()
}