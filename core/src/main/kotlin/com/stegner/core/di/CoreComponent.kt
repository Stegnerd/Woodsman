package com.stegner.core.di

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.stegner.core.di.modules.ContextModule
import com.stegner.core.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Core component that can be used by all modules
 *
 * @see Component
 */
@Singleton
@Component(modules = [
    ContextModule::class,
    NetworkModule::class
])
interface CoreComponent {

    /**
     * Provides dependency graph Context
     *
     * @return Context
     */
    fun context(): Context

    /**
     * Provides dependency FirebaseAuth
     *
     * @return
     */
    fun firebaseAuth(): FirebaseAuth
}
