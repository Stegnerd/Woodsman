/**
 * Configuration of all gradle build plugins.
 */
object BuildPlugins {
    const val ANDROID_APPLICATION = "com.android.application"

    const val KOTLIN_ANDROID = "kotlin-android"
    const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
    const val KOTLIN_KAPT = "kotlin-kapt"


    // Plugins
    const val DETEKT = "plugins.detekt" // Checks for code smell
    const val DOKKA = "plugins.dokka" // Generates documentation
    const val GRAPH_GENERATOR = "com.vanniktech.dependency.graph.generator" // Dependency graph generator
    const val JACOCO = "com.vanniktech.android.junit.jacoco" // Code coverage
    const val KTLINT = "plugins.ktlint" // Kotlin linter
    const val SPOTLESS = "plugins.spotless" // Formatter
}
