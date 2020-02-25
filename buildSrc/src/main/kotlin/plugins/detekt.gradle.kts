package plugins

import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import io.gitlab.arturbosch.detekt.DetektPlugin


/**
 * Configuration for the detekt plugin which checks for code smell and static analysis
 *  Sample: https://github.com/arturbosch/detekt/blob/master/build.gradle.kts
 *
 * Rather than have use plugin{id(detekt)} we use apply<DetektPlugin>()
 * and then set the configuration below it
 *
 * https://guides.gradle.org/migrating-build-logic-from-groovy-to-kotlin/
 *  if you use the imperative apply() function to apply a plugin,
 *  then you will have to use the configure<T>() function to configure that plugin
 */
apply<DetektPlugin>()

configure<DetektExtension> {
    // where to look for files
    input = project.files("src/main/kotlin")
    // setup of rules
    config = files("$rootDir/.detekt/config.yml")

    // where to put the reports
    reports {
        xml {
            enabled = true
            destination = project.file("build/reports/detekt/report.xml")
        }
        html {
            enabled = true
            destination = project.file("build/reports/detekt/report.html")
        }
    }
}
