enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "CookApp"

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
plugins {
    //https://github.com/JetBrains/compose-hot-reload?tab=readme-ov-file#set-up-automatic-provisioning-of-the-jetbrains-runtime-jbr-via-gradle
    id("org.gradle.toolchains.foojay-resolver-convention").version("0.10.0")
}

include(":composeApp")

include(":domain")
include(":presentation")
include(":data")
include(":coreui")
include(":core:config")
include(":core")
include(":navigation")
include(":features:splash")
include(":features:auth")
include(":features:home")
include(":features:setting")
