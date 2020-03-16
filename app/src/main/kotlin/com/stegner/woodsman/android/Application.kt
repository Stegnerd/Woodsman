package com.stegner.woodsman.android

import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompatApplication
import com.stegner.core.di.CoreComponent
import com.stegner.core.di.DaggerCoreComponent
import com.stegner.core.di.modules.ContextModule
import com.stegner.woodsman.android.di.DaggerAppComponent
import timber.log.Timber

/**
 * Base class for global application state
 *
 * @see SplitCompatApplication
 */
class Application : SplitCompatApplication() {

    // main core component that app depends on
    lateinit var coreComponent: CoreComponent

    companion object {

        /**
         * Obtain core dagger component
         *
         * This is needed for features to grab and use
         *
         * @param context The application context
         */
        @JvmStatic
        fun coreComponent(context: Context) = (context.applicationContext as? Application)?.coreComponent
    }

    /**
     * Called when the application is starting, before any activity, service, or receiver objects
     * (excluding context providers) have been created.
     */
    override fun onCreate() {
        super.onCreate()
        initTimber()
        initCoreDependencyInjection()
        initAppDependencyInjection()
    }

    // ====================================
    // Private init methods
    // ====================================

    /**
     * Initialize log library Timber only on debug build.
     */
    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    /**
     * Initialize core dependency injection component.
     */
    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }

    /**
     * Initialize app dependency injection component.
     */
    private fun initAppDependencyInjection() {
        DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }
}
