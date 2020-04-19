package common

import BuildAndroidConfig
import BuildProductDimensions
import ProductFlavorDev
import ProductFlavorQa
import ProductFlavorProduction
import dependencies.Dependencies
import dependencies.AnnotationProcessorsDependencies
import extensions.implementation
import extensions.kapt
import extensions.addTestDependencies
import extensions.testImplementation

/**
 * This is default android configuration of the app.
 */

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("com.vanniktech.android.junit.jacoco")
    id("com.vanniktech.dependency.graph.generator")
}

android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SKD_VERSION)

    defaultConfig {
        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    dataBinding {
        isEnabled = true
    }

    flavorDimensions(BuildProductDimensions.ENVIRONMENT)
    productFlavors {
        ProductFlavorDev.libraryCreate(this)
        ProductFlavorQa.libraryCreate(this)
        ProductFlavorProduction.libraryCreate(this)
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test"){
            java.srcDir("src/test/kotlin")
        }
    }

    lintOptions {
        lintConfig = rootProject.file(".lint/config.xml")
        isCheckAllWarnings = true
        isWarningsAsErrors = true
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }
}

junitJacoco {
    includeNoLocationClasses = true
}

dependencies {
    implementation(Dependencies.COROUTINES)
    implementation(Dependencies.COROUTINES_ANDROID)
    implementation(Dependencies.COROUTINES_PLAY_SERVICES)
    implementation(Dependencies.DAGGER)
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.TIMBER)

    kapt(AnnotationProcessorsDependencies.DAGGER)

    testImplementation(project(BuildModules.Libraries.TEST_UTILS))
    addTestDependencies()
}
