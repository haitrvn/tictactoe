import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

fun Project.configureLibraryAndroidTarget(
    namespace: String? = null,
    minSdk: Int = 21,
    compileSdk: Int = 36,
    javaVersion: JavaVersion = JavaVersion.VERSION_17
) {
    extensions.configure(LibraryExtension::class) {
        this.compileSdk = compileSdk
//        sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
        this.namespace = namespace ?: "com.haitrvn.${project.name.replace("-", ".")}"
        defaultConfig {
            this.minSdk = minSdk
        }
        lint {
            abortOnError = false
        }
        compileOptions {
            sourceCompatibility = javaVersion
            targetCompatibility = javaVersion
        }
    }
}

fun BaseAppModuleExtension.configureApplicationAndroidTarget(
    applicationId: String = "com.haitrvn.cookapp",
    namespace: String = "com.haitrvn.cookapp",
    versionCode: Int = 1,
    versionName: String = "1.0",
    minSdk: Int = 26,
    compileSdk: Int = 36,
    targetSdk: Int = 36,
    javaVersion: JavaVersion = JavaVersion.VERSION_17,
) {
    this.compileSdk = compileSdk

    defaultConfig {
        this.applicationId = applicationId
        this.minSdk = minSdk
        this.targetSdk = targetSdk
        this.versionCode = versionCode
        this.versionName = versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    this.namespace = namespace
    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}