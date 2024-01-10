import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension
import org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
}

description = "Unofficial Kotlin Multiplatform NIDA API implemention using Brela's public url"

kotlin {
    if (Targeting.JVM) jvm { library() }
    if (Targeting.JS) js(IR) { library() }
//    if (Targeting.WASM) wasmJs { library() }
    val osxTargets = if (Targeting.OSX) osxTargets() else listOf()
//    val ndkTargets = if (Targeting.NDK) ndkTargets() else listOf()
    val linuxTargets = if (Targeting.LINUX) linuxTargets() else listOf()
//    val mingwTargets = if (Targeting.MINGW) mingwTargets() else listOf()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.kidaApi)
                api(libs.koncurrent.later.coroutines)
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
                implementation(libs.koncurrent.later.coroutines)
                implementation(libs.kommander.coroutines)
            }
        }
    }
}

//rootProject.the<NodeJsRootExtension>().apply {
//    nodeVersion = npm.versions.node.version.get()
//    nodeDownloadBaseUrl = npm.versions.node.url.get()
//}
//
//rootProject.tasks.withType<KotlinNpmInstallTask>().configureEach {
//    args.add("--ignore-engines")
//}
//
//tasks.named("wasmJsTestTestDevelopmentExecutableCompileSync").configure {
//    mustRunAfter(tasks.named("jsBrowserTest"))
//    mustRunAfter(tasks.named("jsNodeTest"))
//}