enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "CookApp"

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
                includeGroupByRegex("android.*")
            }
        }
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
                includeGroupByRegex("android.*")
            }
        }
        mavenCentral()
    }
    versionCatalogs {
        create("haitrvn") {
            from(files("./build-logic/building.versions.toml"))
        }
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
include(":core:ui")
include(":core:config")
include(":core")
include(":navigation")
include(":features:splash")
include(":features:auth")
include(":features:home")
include(":features:setting")
