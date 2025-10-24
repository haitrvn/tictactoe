plugins {
    id(libs.plugins.multiplatform.get().pluginId)
    id(libs.plugins.compose.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.composecompiler)
}

kotlin {
    allTargets()
    defaultConfig()
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.coreui)
                implementation(projects.core)
                implementation(libs.kotlin.stdlib)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.androidx.nav3.ui)
                implementation(libs.koin.core)
                implementation(libs.koin.compose)

                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

configureLibraryAndroidTarget()