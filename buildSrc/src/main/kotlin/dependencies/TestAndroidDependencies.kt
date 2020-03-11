
package dependencies

/**
 * Project androidTest dependencies.
 */
object TestAndroidDependencies {
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${BuildDependenciesVersions.ESPRESSO}"
    const val JUNIT = "androidx.test.ext:junit:${BuildDependenciesVersions.EXT}"
    const val MOCKITO = "com.nhaarman.mockitokotlin2:mockito-kotlin:${BuildDependenciesVersions.MOCKITO}"
    const val RUNNER = "androidx.test:runner:${BuildDependenciesVersions.TEST}"
}
