
package plugins

import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin

/**
 * Configuration for the spotless plugin which is a code formatter
 * Sample: https://github.com/diffplug/spotless/tree/master/plugin-gradle
 *
 * Rather than have use plugin{id(spotless)} we use apply<SpotlessPlugin>()
 * and then set the configuration below it
 *
 * https://guides.gradle.org/migrating-build-logic-from-groovy-to-kotlin/
 *  if you use the imperative apply() function to apply a plugin,
 *  then you will have to use the configure<T>() function to configure that plugin
 */
apply<SpotlessPlugin>()

configure<SpotlessExtension> {
    // format for types described in include section
    format("misc") {
        target(
            fileTree(
                mapOf(
                    "dir" to ".",
                    "include" to listOf(
                        "**/*.md",
                        "**.*gitignore",
                        "**/*.yaml",
                        "**/*.yml"),
                    "exclude" to listOf(
                        ".gradle/**",
                        ".gradle-cache/**",
                        "**/tools/**",
                        "**/build/**"
                    )
                )
            )
        )
        trimTrailingWhitespace()
        indentWithSpaces(2)
        endWithNewline()
    }

    // Formatting declared for xml files
    format("xml") {
        target("**/res/**/*.xml")
        indentWithTabs(4)
        trimTrailingWhitespace()
        endWithNewline()
    }

    // Formatting declared for Kotlin files
    kotlin {
        target(
            fileTree(
                mapOf(
                    "dir" to ".",
                    "include" to listOf("**/*.kt"),
                    "exclude" to listOf("**/build/**", "**/buildSrc/**", "**/.*")
                )
            )
        )
        trimTrailingWhitespace()
        indentWithSpaces(4)
        endWithNewline()
    }

    // Formatting declared for gradle build files
    kotlinGradle {
        target(
            fileTree(
                mapOf(
                    "dir" to ".",
                    "include" to listOf("**/*.gradel.kts", "*.gradle.kts"),
                    "exclude" to listOf("**/build/**")
                )
            )
        )
        trimTrailingWhitespace()
        indentWithSpaces(4)
        endWithNewline()
    }
}
