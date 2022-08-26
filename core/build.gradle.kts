plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    jvm { library() }
    js(IR) { library() }
//    val nativeTargets = nativeTargets(true)
//    val nativeTargets = linuxTargets(true)

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.koncurrentLaterCoroutines)
                api(ktor.client.core)
                api(kotlinx.serialization.json)
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
                implementation(projects.expectCoroutines)
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.root.get(),
    description = "Unofficial Kotlin Multiplatform NIDA API"
)