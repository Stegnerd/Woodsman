
import dependencies.Dependencies
import extensions.addTestDependencies
import extensions.implementation

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)
}

android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SKD_VERSION)

    defaultConfig{
        applicationId = BuildAndroidConfig.APPLICATION_ID

        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)

        buildToolsVersion(BuildAndroidConfig.BUILD_TOOLS_VERSION)

        versionCode = BuildAndroidConfig.VERSION_CODE
        versionName = BuildAndroidConfig.VERSION_NAME

        vectorDrawables.useSupportLibrary = BuildAndroidConfig.SUPPORT_LIBRARY_VECTOR_DRAWABLES
        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    // TODO: Need to configure signing configs and build types
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    flavorDimensions(BuildProductDimensions.ENVIRONMENT)
    productFlavors{
        ProductFlavorDev.appCreate(this)
        ProductFlavorQa.appCreate(this)
        ProductFlavorProduction.appCreate(this)
    }

    // TODO Add dynamic features here

    dataBinding {
        isEnabled = true
    }

    androidExtensions {
        isExperimental = true
    }

    compileOptions{
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    // TODO add lint congfig here

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
        getByName("androidTest"){
            java.srcDir("src/androidTest/kotlin")
        }
    }
}

dependencies {
    implementation(project(BuildModules.CORE))
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.CONSTRAIN_LAYOUT)

    addTestDependencies()
}