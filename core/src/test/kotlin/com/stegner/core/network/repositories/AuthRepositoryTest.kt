package com.stegner.core.network.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.firebase.auth.FirebaseUser
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.stegner.core.network.services.AuthService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.MockitoAnnotations

object TestObjects {

    object SampleUser {
        const val email = "test@testMail.com"
        const val password = "Password123"
    }
}

/**
 * Unit tests for the [AuthRepository]
 *
 * Note that CurrentUser always returns a mocked instance
 */
class AuthRepositoryTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var authService: AuthService

    @Mock
    lateinit var firebaseUser: FirebaseUser

    // system under test
    private lateinit var authRepository: AuthRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        authRepository = AuthRepository(authService)
    }

    @Test
    fun login_success() = runBlocking {

        // Arrange
        whenever(authService.currentUser()).thenReturn(firebaseUser)

        // Act
        val result = authRepository.login(TestObjects.SampleUser.email, TestObjects.SampleUser.password)

        // Assert
        verify(authService).login(anyString(), anyString())
        assertEquals(result.success, true)
        assertNotEquals(result.data, null)
    }

    @Test
    fun login_failure() = runBlocking {

        // Arrange
        whenever(authService.currentUser()).thenReturn(null)

        // Act
        val result = authRepository.login(TestObjects.SampleUser.email, TestObjects.SampleUser.password)

        // Assert
        verify(authService).login(anyString(), anyString())
        assertEquals(result.success, false)
        assertEquals(result.data, null)
    }

    @Test
    fun register_success() = runBlocking {

        // Arrange
        whenever(authService.currentUser()).thenReturn(firebaseUser)

        // Act
        val result = authRepository.register(TestObjects.SampleUser.email, TestObjects.SampleUser.password)

        // Assert
        verify(authService).register(anyString(), anyString())
        assertEquals(result.success, true)
        assertNotEquals(result.data, null)
    }

    @Test
    fun register_failure() = runBlocking {

        // Arrange
        whenever(authService.currentUser()).thenReturn(null)

        // Act
        val result = authRepository.register(TestObjects.SampleUser.email, TestObjects.SampleUser.password)

        // Assert
        verify(authService).register(anyString(), anyString())
        assertEquals(result.success, false)
        assertEquals(result.data, null)
    }

    @Test
    fun logout_verify() {

        // Arrange & Act
        authRepository.logout()

        // Assert
        verify(authService).logout()
    }

    @Test
    fun currentUser_notLoggedIn() {

        // Arrange
        whenever(authService.currentUser()).thenReturn(null)

        // Act
        val result = authRepository.currentUser()

        // Assert
        verify(authService).currentUser()
        assertEquals(result.success, false)
        assertEquals(result.data, null)
    }

    @Test
    fun currentUser_loggedIn() {

        // Arrange
        whenever(authService.currentUser()).thenReturn(firebaseUser)

        // Act
        val result = authRepository.currentUser()

        // Assert
        verify(authService).currentUser()
        assertEquals(result.success, true)
        assertNotEquals(result.data, null)
    }
}
