package com.stegner.core.di.modules

import com.google.firebase.auth.FirebaseAuth
import com.stegner.core.network.repositories.AuthRepository
import com.stegner.core.network.services.AuthService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Singleton
    @Provides
    fun provideAuthService(firebase: FirebaseAuth) = AuthService(firebase)

    @Singleton
    @Provides
    fun providesAuthRepository(service: AuthService) = AuthRepository(service)
}
