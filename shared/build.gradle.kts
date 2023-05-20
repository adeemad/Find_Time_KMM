//Gradle can automatically read the constants defined within buildSrc.
plugins {
    //The first plugin is for KMP and defines this module as a multiplatform module.
    kotlin(multiplatform)
    //The next plugin is for iOS and brings in CocoaPods.
    kotlin(cocopods)
    //The last plugin is for Android.You’ll use this to create an Android library for use in an Android app
    id(androidLib)
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

    //define the source sets. These use predefined variables
    sourceSets {
        //Define the commonMain and testing dependencies. Currently, commonMain has none
        val commonMain by getting {
            dependencies {
                // 1
                implementation(Deps.JetBrains.datetime)
                // 2
                implementation(Deps.napier)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        //Define the commonMain and testing dependencies. Currently, commonMain has none
        val androidMain by getting
        val androidUnitTest by getting

        //Define the commonMain and testing dependencies. Currently, commonMain has none
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

//android section
android {
    namespace = "com.adabdigital.findtime"
    compileSdk = Versions.compile_sdk
    defaultConfig {
        minSdk = Versions.min_sdk
    }
}