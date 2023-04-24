plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
}

description = "Unofficial Kotlin Multiplatform NIDA API implemention using Brela's public url"

kotlin {
    if (Targeting.JVM) jvm { library() }
    if (Targeting.JS) js(IR) { library() }
//    if (Targeting.WASM) wasm { library() }
    val osxTargets = if (Targeting.OSX) osxTargets() else listOf()
//    val ndkTargets = if (Targeting.NDK) ndkTargets() else listOf()
    val linuxTargets = if (Targeting.LINUX) linuxTargets() else listOf()
//    val mingwTargets = if (Targeting.MINGW) mingwTargets() else listOf()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.kidaApi)
                api(projects.koncurrentLaterCoroutines)
                api(ktor.client.core)
            }
        }

        val jvmMain by getting {
            dependencies {
                api(ktor.client.cio)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(projects.koncurrentLaterTest)
                implementation(projects.kommanderCoroutines)
            }
        }
    }
}