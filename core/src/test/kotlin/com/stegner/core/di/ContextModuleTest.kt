package com.stegner.core.di

import android.app.Application
import com.stegner.core.di.modules.ContextModule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Unit tests for [ContextModule] of Core DI
 */
class ContextModuleTest {

    // creates a mock instance of Application
    @Mock
    lateinit var application: Application
    private lateinit var contextModule: ContextModule

    @Before
    fun setUp() {
        // initialize all objects that are marked with @Mock
        MockitoAnnotations.initMocks(this)

        // Instantiate that lateinit var to avoid runtime errors
        contextModule = ContextModule(application)
    }

    @Test
    fun verifyProvidedContext() {
        assertEquals(application, contextModule.providesContext())
    }
}
