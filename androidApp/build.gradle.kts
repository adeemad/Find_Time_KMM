import Deps.Compose.activity
import Deps.Compose.foundation
import Deps.Compose.tooling
import Deps.Compose.ui
import Deps.material

plugins {
    id(androidApp)
    kotlin(androidPlugin)
}

android {
    namespace = "com.adabdigital.findtime.android"
    compileSdk = Versions.compile_sdk
    defaultConfig {
        applicationId = "com.adabdigital.findtime.android"
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    // napier, a multiplatform library for logging, and the Google material library
    with(Deps) {
        implementation(napier)
        implementation(material)
    }

    implementation(project(":shared"))
    with(Deps.Compose) {
        implementation(ui)
        implementation(tooling)
        implementation(tooling_preview)
        implementation(foundation)
        implementation(material)
        implementation(activity)
    }
}