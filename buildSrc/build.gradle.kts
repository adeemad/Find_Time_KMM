//One of the nice features of the newer Gradle versions is the concept of the buildSrc module.
// This is a module where you can define version variables as well as define your own plugins.
repositories {
    mavenCentral()
}

plugins {
    `kotlin-dsl`
}