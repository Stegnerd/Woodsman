
import com.android.build.gradle.internal.dsl.ProductFlavor
import org.gradle.api.NamedDomainObjectContainer

/**
 * Configuration of different build types of the app.
 */
interface BuildProductFlavor {
    val name: String

    fun libraryCreate(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>):ProductFlavor

    fun appCreate(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>):ProductFlavor
}

object ProductFlavorDev : BuildProductFlavor {
    override val name = "dev"

    override fun appCreate(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>):ProductFlavor {
        return namedDomainObjectContainer.create(name) {
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
            dimension = BuildProductDimensions.ENVIRONMENT
        }
    }

    override fun libraryCreate(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>): ProductFlavor {
        return namedDomainObjectContainer.create(name) {
            versionNameSuffix = "-dev"
            dimension = BuildProductDimensions.ENVIRONMENT
        }
    }
}

object ProductFlavorQa : BuildProductFlavor {
    override val name = "qa"

    override fun appCreate(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>):ProductFlavor {
        return namedDomainObjectContainer.create(name) {
            applicationIdSuffix = ".qa"
            versionNameSuffix = "-qa"
            dimension = BuildProductDimensions.ENVIRONMENT
        }
    }

    override fun libraryCreate(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>): ProductFlavor {
        return namedDomainObjectContainer.create(name) {
            versionNameSuffix = "-qa"
            dimension = BuildProductDimensions.ENVIRONMENT
        }
    }
}

object ProductFlavorProduction : BuildProductFlavor {
    override val name = "prod"

    override fun appCreate(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>): ProductFlavor {
        return namedDomainObjectContainer.create(name) {
            dimension = BuildProductDimensions.ENVIRONMENT
        }
    }

    override fun libraryCreate(namedDomainObjectContainer: NamedDomainObjectContainer<ProductFlavor>): ProductFlavor {
        return namedDomainObjectContainer.create(name) {
            dimension = BuildProductDimensions.ENVIRONMENT
        }
    }
}
