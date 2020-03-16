package com.stegner.woodsman.android.di

import android.content.Context
import com.stegner.woodsman.android.Application
import dagger.Module
import dagger.Provides

/**
 * Class that contributes to the object graph [AppComponent]
 */
@Module
class AppModule {

    /**
     * Create a provider method binding for [Context]
     *
     * @param application The Application itself.
     * @return Instance of context.
     * @see Provides
     */
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

}
