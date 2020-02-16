
plugins {
    `kotlin-dsl`
}

repositories{
    google()
    jcenter()
}

kotlinDslPluginOptions{
    experimentalWarning.set(false)
}

object PluginVersions {
    const val GRADLE_ANDROID = "3.6.0-rc02"
    const val KOTLIN = "1.3.61"
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginVersions.GRADLE_ANDROID}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersions.KOTLIN}")
}
