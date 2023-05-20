plugins {
    //The first plugin is for KMP and defines this module as a multiplatform module.
    kotlin("multiplatform")
    //The next plugin is for iOS and brings in CocoaPods.
    kotlin("native.cocoapods")
    //The last plugin is for Android.You’ll use this to create an Android library for use in an Android app
    id("com.android.library")
}

kotlin {
    // define an android target
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    //defines a target for the iOS simulator on x86_64 platforms
    iosX64()
    //defines a target for iOS on ARM64 platforms.
    iosArm64()
    iosSimulatorArm64()

    //Defines the details for building the CocoaPods Podfile
    //The main thing here is the baseName, which is shared, and the path to the Podfile.
    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }
    
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.adabdigital.findtime"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}