
plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories{
    google()
    jcenter()
    mavenCentral()

    // needed for custom plugin configuration

    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://plugins.gradle.org/m2/")
}

kotlinDslPluginOptions{
    experimentalWarning.set(false)
}

object PluginVersions {
    const val GRADLE_ANDROID = "3.6.0"
    const val KOTLIN = "1.3.61"

    // Firebase & Google
    const val GOOGLE_SERVICES = "4.3.3"

    // Plugins
    const val DETEKT = "1.2.2"
    const val DOKKA = "0.10.0"
    const val KTLINT = "0.36.0"
    const val SPOTLESS = "3.27.1"
    const val JACOCO = "0.16.0-SNAPSHOT"
    const val GRAPH_GENERATOR = "0.6.0-SNAPSHOT"
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginVersions.GRADLE_ANDROID}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersions.KOTLIN}")

    // Firebase & Google
    implementation("com.google.gms:google-services:${PluginVersions.GOOGLE_SERVICES}")

    // plugins
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${PluginVersions.DETEKT}")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:${PluginVersions.DOKKA}")
    implementation("com.pinterest:ktlint:${PluginVersions.KTLINT}")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:${PluginVersions.SPOTLESS}")
    implementation("com.vanniktech:gradle-android-junit-jacoco-plugin:${PluginVersions.JACOCO}")
    implementation("com.vanniktech:gradle-dependency-graph-generator-plugin:${PluginVersions.GRAPH_GENERATOR}")
}
