package com.stegner.core.di

import com.google.firebase.auth.FirebaseAuth
import com.nhaarman.mockitokotlin2.mock
import com.stegner.core.di.modules.NetworkModule
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Unit tests for [NetworkModule] of Core DI
 */
class NetworkModuleTest {

    private lateinit var networkModule: NetworkModule

    @Before
    fun setUp() {
        networkModule = NetworkModule()

        mockkStatic(FirebaseAuth::class)
        every { FirebaseAuth.getInstance() } returns mockk(relaxed = true)
    }

    @Test
    fun verifyProvideFirebaseAuth() {
        val firebaseAuth = networkModule.provideFirebaseAuth()

        assertEquals(firebaseAuth::class, FirebaseAuth::class)
    }

    @Test
    fun verifyProvideAuthService() {
        val firebaseAuth = mock<FirebaseAuth>()
        val authService = networkModule.provideAuthService(firebaseAuth)

        assertEquals(authService.firebase, firebaseAuth)
    }
}
