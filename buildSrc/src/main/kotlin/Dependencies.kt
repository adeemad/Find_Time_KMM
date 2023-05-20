//This file will contain all the variables you’ll need to define all your plugins and dependencies.
//The reason for creating this file is to avoid having to maintain all the versions for your plugins and dependencies in many different files.
//Defining the versions in one place makes it easy to change later.

const val androidPlugin = "android"
const val androidApp = "com.android.application"
const val androidLib = "com.android.library"
const val multiplatform = "multiplatform"
const val composePlugin = "org.jetbrains.compose"
const val cocopods = "native.cocoapods"

//The code above defines regular Kotlin variables you can use throughout your Gradle scripts.
// These aren’t required, but they make it easier to add.


//Next, define the version numbers by adding the following code:
object Versions {
    // 1 These define the SDK versions for Android
    const val min_sdk = 24
    const val target_sdk = 31
    const val compile_sdk = 31

    // 2 These define the versions for your plugins.
    // Plugins
    const val kotlin = "1.6.10"
    const val kotlin_gradle_plugin = "1.6.10"
    const val android_gradle_plugin = "7.0.4"
    const val desktop_compose_plugin = "1.0.1"
    const val compose_compiler_version= "1.1.0-rc02"
    const val compose_version= "1.1.0-rc01"

    //3 Version numbers for your libraries.
    const val coroutines = "1.5.0-native-mt"
    const val junit = "4.13.2"
    const val material = "1.4.0"
    const val kotlinxDateTime = "0.3.1"
    const val activity_compose = "1.4.0"
    const val napier = "2.1.0"
    const val junit5 = "1.5.10"
    const val frameworkName = "shared"
}
