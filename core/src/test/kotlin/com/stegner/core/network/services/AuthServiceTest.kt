package com.stegner.core.network.services

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

object TestObjects {

    object SampleUser {
        const val email = "test@testMail.com"
        const val password = "Password123"
    }
}

/**
 * Unit Tests for the Auth Service
 *
 * Learnings:
 *  1. when testing coroutines need to use coEvery, coVerify
 *  2. used kotlin dsl to establish mockks easier, and OverrideMockks injects those mocks into services
 *      that need them
 *
 */
class AuthServiceTest {

    // Create a test rule that causes async calls to return instantly
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun register_success() = runBlocking {
    }

    @Test
    fun register_failure() {
    }

    @Test
    fun login_success() {
    }

    @Test
    fun login_failure() {
    }

    @Test
    fun logout() {
    }

    @Test
    fun getCurrentUser() {
    }
}
