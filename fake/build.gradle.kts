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
    val nativeTargets = linuxTargets(true)

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.kidaCore)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(projects.koncurrentLaterTest)
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.root.get(),
    description = "An implementation of the cache-api to help caching simple objects in memory"
)