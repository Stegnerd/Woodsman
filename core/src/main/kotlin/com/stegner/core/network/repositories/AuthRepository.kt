package com.stegner.core.network.repositories

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.stegner.core.network.responses.BaseResponse
import com.stegner.core.network.services.AuthService
import com.stegner.core.di.modules.NetworkModule

/**
 * Repository module for handling FirebaseAuth network operations [AuthService]
 *
 * service is open for testing to allow testing the [NetworkModule]
 */
class AuthRepository(@VisibleForTesting(otherwise = PRIVATE) internal val service: AuthService) {

    /**
     * Attempts to log a user into the application
     *
     * @param email Email of the user logging in
     * @param password Password of the user logging in
     * @return An instance of [FirebaseUser] or null
     */
    suspend fun login(email: String, password: String): BaseResponse<FirebaseUser?> {
        service.login(email, password)

        val user = service.currentUser()

        // If user successfully logged in return user
        // otherwise return null
        return if (user == null) {
            BaseResponse(false, null)
        } else {
            BaseResponse(true, user)
        }
    }

    /**
     * Attempts to sign a user up with [FirebaseAuth] using password and email.
     *
     * @param email Email that user is attempting to sign up with
     * @param password Password of the user attempting to sign up
     * @return An instance of [FirebaseUser] or null
     */
    suspend fun register(email: String, password: String): BaseResponse<FirebaseUser?> {
        service.register(email, password)

        val user = service.currentUser()

        // If user successfully logged in return user
        // otherwise return null
        return if (user == null) {
            BaseResponse(false, null)
        } else {
            BaseResponse(true, user)
        }
    }

    /**
     * Signs current user out of [FirebaseAuth]
     */
    fun logout() = service.logout()

    /**
     * Gets instance of user currently signed in
     */
    fun currentUser(): BaseResponse<FirebaseUser?> {
        val user = service.currentUser()

        // If user successfully logged in return user
        // otherwise return null
        return if (user == null) {
            BaseResponse(false, null)
        } else {
            BaseResponse(true, user)
        }
    }
}
