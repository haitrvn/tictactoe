package org.haitrvn.plugin.convention

import org.gradle.api.Project
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.Properties

object AndroidBuildConfig {
    const val compileSdkVersion = 34
    const val minSdkVersion = 28
    const val targetSdkVersion = 34
    const val applicationId = "com.haitrvn.id"
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

fun Project.getPropertiesByFile(path: String): Properties {
    val properties = Properties()
    val keyPropertiesFile = rootProject.file(path)

    if (keyPropertiesFile.isFile) {
        InputStreamReader(FileInputStream(keyPropertiesFile), Charsets.UTF_8).use { reader ->
            properties.load(reader)
        }
    }
    return properties
}