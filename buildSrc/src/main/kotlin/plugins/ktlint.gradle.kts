

package plugins


/**
 * Configuration for the ktlint configuration which checks kotlin code for standards
 * Sample: https://github.com/diffplug/spotless/tree/master/plugin-gradle
 *
 * Rather than have use plugin{id(spotless)} we use apply<SpotlessPlugin>()
 * and then set the configuration below it
 *
 * https://guides.gradle.org/migrating-build-logic-from-groovy-to-kotlin/
 *  if you use the imperative apply() function to apply a plugin,
 *  then you will have to use the configure<T>() function to configure that plugin
 */


val ktlint : Configuration by configurations.creating

dependencies {
    ktlint("com.pinterest:ktlint:0.36.0")
}

tasks {
    // checks project to make sure all kt files obey kotlin standards
    register<JavaExec>("ktlint") {
        group = BuildTasksGroups.VERIFICATION
        description = "Check Koltin code style."
        classpath = ktlint
        main = "com.pinterest.ktlint.Main"
        args("--android", "src/**/*.kt")
    }

    // fixes problems found in the ktlint task
    // -F stands for auto fix violations
    register<JavaExec>("ktlintFormat") {
        group = BuildTasksGroups.FORMATTING
        description = "Fix Kotlin code style deviations."
        classpath = ktlint
        main = "com.pinterest.ktlint.Main"
        args("--android", "-F", "src/**/*.kt")
    }
}
