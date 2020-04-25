/**
 * Configuration of  build modules.
 */
object BuildModules {
    const val APP = ":app"
    const val CORE = ":core"

    object Features {
        const val AUTHENTICATION = ":features:authentication"
        const val HOME = ":features:home"
    }

    object Common {
        const val UI = ":common:ui"
    }

    object Libraries {
        const val TEST_UTILS = ":libraries:test_utils"
    }
}
