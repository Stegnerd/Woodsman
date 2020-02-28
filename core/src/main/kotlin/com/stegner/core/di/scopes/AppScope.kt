package com.stegner.core.di.scopes

import javax.inject.Scope

/**
 * Dagger scope for the entire app runtime.
 *
 * Runtime means that the binary is visible and available for reflection
 */
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class AppScope
