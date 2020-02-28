

package dependencies

/**
 * Project dependencies.
 */
object Dependencies {

    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${BuildDependenciesVersions.KOTLIN}"

    const val APPCOMPAT = "androidx.appcompat:appcompat:${BuildDependenciesVersions.APPCOMPAT}"
    const val CORE_KTX = "androidx.core:core-ktx:${BuildDependenciesVersions.CORE_KTX}"
    const val CONSTRAIN_LAYOUT = "androidx.constraintlayout:constraintlayout:${BuildDependenciesVersions.CONSTRAINT_LAYOUT}"
    const val DAGGER = "com.google.dagger:dagger:${BuildDependenciesVersions.DAGGER}"
    const val TIMBER = "com.jakewharton.timber:timber:${BuildDependenciesVersions.TIMBER}"
    
    // Firebase
    const val FIREBASE_ANALYTICS = "com.google.firebase:firebase-analytics:${BuildDependenciesVersions.FIREBASE_ANALYTICS}"
    const val FIREBASE_AUTH = "com.google.firebase:firebase-auth:${BuildDependenciesVersions.FIREBASE_AUTH}"
    const val FIREBASE_CRASHLYTICS = "com.google.firebase:firebase-crashlytics:${BuildDependenciesVersions.FIREBASE_CRASHLYTICS}"
}
