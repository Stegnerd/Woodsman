package com.stegner.core.network.services

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

/**
 * Abstraction around [FirebaseAuth] implementation.
 *
 * VisibleForTesting is used for reference in unit tests like this AuthService.firebase
 * internal is used so that all of com.stegner.core.network.services can see it
 */
class AuthService(@VisibleForTesting(otherwise = PRIVATE)internal val firebase: FirebaseAuth) {

    /**
     * Logs a user into [FirebaseAuth] with password and email.
     *
     * @param email Email of the user logging in
     * @param password Password of the user logging in
     * @return An instance of [FirebaseUser] or null
     */
    suspend fun login(email: String, password: String) {
        // by using await (which is using google services api wrapper) able to wait for action to be done
        // before attempting to check  and can launch this with Kotlin coroutine in viewmodel
        firebase.signInWithEmailAndPassword(email, password).await()
    }

    /**
     * Attempts to sign a user up with [FirebaseAuth] using password and email.
     *
     * @param email Email that user is attempting to sign up with
     * @param password Password of the user attempting to sign up
     * @return An instance of [FirebaseUser] or null
     */
    suspend fun register(email: String, password: String) {
        // by using await (which is using google services api wrapper) able to wait for action to be done
        // before attempting to check  and can launch this with Kotlin coroutine in viewmodel
        firebase.createUserWithEmailAndPassword(email, password).await()
    }

    /**
     * Signs current user out of [FirebaseAuth]
     */
    fun logout() = firebase.signOut()

    /**
     * Gets instance of user currently signed in
     */
    fun currentUser(): FirebaseUser? {
        return firebase.currentUser
    }
}
