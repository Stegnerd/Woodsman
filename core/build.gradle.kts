
import dependencies.Dependencies
import extensions.implementation

plugins {
    id("common.android-library")
}


dependencies {
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.FIREBASE_AUTH)
}
