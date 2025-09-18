plugins {
    id(libs.plugins.multiplatform.get().pluginId)
    id(libs.plugins.compose.get().pluginId)
    id(libs.plugins.android.library.get().pluginId)
    alias(libs.plugins.composecompiler)
}

kotlin {
    allTargets()
    defaultConfig()
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.core)
                implementation(projects.coreui)

                implementation(libs.kotlin.stdlib)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(libs.androidx.lifecycle.runtime.compose)
                implementation(libs.koin.compose)
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

compose.resources {
    publicResClass = true
    packageOfResClass = "cookapp.resources.setting"
    generateResClass = auto
}