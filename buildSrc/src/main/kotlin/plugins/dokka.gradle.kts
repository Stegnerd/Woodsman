
package plugins

import org.jetbrains.dokka.gradle.DokkaPlugin
import org.jetbrains.dokka.gradle.DokkaTask

/**
 * Configuration for the dokka plugin which generates documentation for our code
 *  Sample: https://github.com/Kotlin/dokka
 *
 * Rather than have use plugin{id(dokka)} we use apply<DokkaPlugin>()
 * and then set the configuration below it
 *
 * https://guides.gradle.org/migrating-build-logic-from-groovy-to-kotlin/
 *  if you use the imperative apply() function to apply a plugin,
 *  then you will have to use the configure<T>() function to configure that plugin
 */
apply<DokkaPlugin>()

tasks {
    withType<DokkaTask> {
        outputFormat = "html"
        outputDirectory = "${rootProject.rootDir}/documentation"

        configuration {
            // naming convention for folders in the documentation section
            moduleName = project.parent?.let {parentProject ->
                if(parentProject.name == rootProject.name){
                    project.name
                } else {
                    "${parentProject.name}/${project.name}"
                }
            } ?: run {
                project.name
            }
        }
    }
}
