import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(haitrvn.android.tools.build)
    compileOnly(haitrvn.android.tools.common)
    compileOnly(haitrvn.compose.gradle.plugin)
    compileOnly(haitrvn.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins.register("androidApplication") {
        id = "haitrvn.android.application"
        implementationClass = "org.haitrvn.mobile.convention.plugins.AndroidApplicationConventionPlugin"
    }
    plugins.register("androidApplicationCompose") {
        id = "haitrvn.android.application.compose"
        implementationClass = "org.haitrvn.mobile.convention.plugins.AndroidApplicationComposeConventionPlugin"
    }
    plugins.register("androidLibrary") {
        id = "haitrvn.android.library"
        implementationClass = "org.haitrvn.mobile.convention.plugins.AndroidLibraryConventionPlugin"
    }
    plugins.register("androidLibraryCompose") {
        id = "haitrvn.android.library.compose"
        implementationClass = "org.haitrvn.mobile.convention.plugins.AndroidLibraryComposeConventionPlugin"
    }
    plugins.register("androidLint") {
        id = "haitrvn.android.lint"
        implementationClass = "org.haitrvn.mobile.convention.plugins.AndroidLintConventionPlugin"
    }
    plugins.register("androidTest") {
        id = "haitrvn.android.test"
        implementationClass = "org.haitrvn.mobile.convention.plugins.AndroidTestConventionPlugin"
    }
    plugins.register("androidJacoco") {
        id = "haitrvn.android.jacoco"
        implementationClass = "org.haitrvn.mobile.convention.plugins.JacocoConventionPlugin"
    }
    plugins.register("jvmLibrary") {
        id = "haitrvn.library.jvm"
        implementationClass = "org.haitrvn.mobile.convention.plugins.JvmLibraryConventionPlugin"
    }
    plugins.register("androidKoin") {
        id = "haitrvn.android.koin"
        implementationClass = "org.haitrvn.mobile.convention.plugins.KoinConventionPlugin"
    }
    plugins.register("multiplatformLibrary") {
        id = "haitrvn.library.multiplatform"
        implementationClass = "org.haitrvn.mobile.convention.plugins.MultiplatformCommonConventionPlugin"
    }
}
