import org.gradle.kotlin.dsl.asoft
import java.text.SimpleDateFormat
import java.util.*

@Suppress("DSL_SCOPE_VIOLATION") plugins {
    alias(androidx.plugins.library) apply false
    alias(kotlinz.plugins.multiplatform) apply false
    alias(kotlinz.plugins.serialization) apply false
    alias(kotlinz.plugins.compose) apply false
    alias(asoft.plugins.library) apply false
    alias(kotlinz.plugins.dokka)
    alias(nexus.plugins.publish)
    alias(asoft.plugins.deploy)
}

// Incrememnt this counter, when you just need to make a dispatch
val dispatchCount = 5

allprojects {
    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }

    afterEvaluate {
        group = "tz.co.asoft"
        version = asoft.versions.root.get()
    }
}