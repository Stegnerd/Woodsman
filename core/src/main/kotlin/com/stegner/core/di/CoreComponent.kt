package com.stegner.core.di

import android.content.Context
import dagger.Component
import javax.inject.Singleton

/**
 * Core component that can be used by all modules
 *
 * @see Component
 */
@Singleton
@Component(modules = [])
interface CoreComponent {

    /**
     * Provides dependency graph Context
     *
     * @return Context
     */
    fun context(): Context
}
