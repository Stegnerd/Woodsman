package com.stegner.woodsman.android.di

import com.stegner.core.di.CoreComponent
import com.stegner.core.di.scopes.AppScope
import com.stegner.woodsman.android.Application
import dagger.Component

/**
 * App component that the application component's (feature) components depend on
 *
 * @see Component
 */
@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {

    /**
     * Inject dependencies into application
     *
     * @param application The Top level application
     */
    fun inject(application: Application)
}
