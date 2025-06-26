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
        implementationClass =
            "org.haitrvn.plugin.convention.plugins.AndroidApplicationConventionPlugin"
    }
}
