
package dependencies

/**
 * Project test dependencies.
 */
object TestDependencies {
    const val ARCH_CORE = "androidx.arch.core:core-testing:${BuildDependenciesVersions.ARCH_CORE}"
    const val EXT = "androidx.test.ext:junit:${BuildDependenciesVersions.EXT}"
    const val JUNIT = "junit:junit:${BuildDependenciesVersions.JUNIT}"
    const val RUNNER = "androidx.test:runner:${BuildDependenciesVersions.TEST}"
    const val MOCKITO = "com.nhaarman.mockitokotlin2:mockito-kotlin:${BuildDependenciesVersions.MOCKITO}"
    const val MOCKK = "io.mockk:mockk:${BuildDependenciesVersions.MOCKK}"
}
