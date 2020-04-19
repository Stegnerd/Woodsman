
import dependencies.Dependencies
import dependencies.TestDependencies
import dependencies.AnnotationProcessorsDependencies
import extensions.implementation

plugins {
    id("common.android-library")
}

dependencies {
    implementation(Dependencies.NAVIGATION_UI)

    implementation(TestDependencies.ASSERTJ)
    implementation(TestDependencies.CORE)
    implementation(TestDependencies.EXT)
    implementation(TestDependencies.FRAGMENT_TEST)
    implementation(TestDependencies.MOCKITO)
    implementation(TestDependencies.ROBOELECTRIC)
    implementation(TestDependencies.RULES)
    implementation(TestDependencies.RUNNER)

    annotationProcessor(AnnotationProcessorsDependencies.AUTO_SERVICE)
}
