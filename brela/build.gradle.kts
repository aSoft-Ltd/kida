plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
}

description = "Unofficial Kotlin Multiplatform NIDA API implemention using Brela's public url"

kotlin {
    if (Targeting.JVM) jvm { library() }
    if (Targeting.JS) js(IR) { library() }
    if (Targeting.WASM) wasmJs { library() }
    if (Targeting.OSX) osxTargets() else listOf()
//    if (Targeting.NDK) ndkTargets() else listOf()
    if (Targeting.LINUX) linuxTargets() else listOf()
//    if (Targeting.MINGW) mingwTargets() else listOf()

    sourceSets {
        commonMain.dependencies {
            api(projects.kidaApi)
            api(kotlinx.serialization.json)
            api(ktor.client.core)
        }

        commonTest.dependencies {
            api(kotlinx.serialization.json)
            implementation(libs.kommander.coroutines)
        }

        if(Targeting.JVM) jvmTest.dependencies {
            implementation(ktor.client.cio)
            implementation(kotlin("test-junit5"))
        }
    }
}