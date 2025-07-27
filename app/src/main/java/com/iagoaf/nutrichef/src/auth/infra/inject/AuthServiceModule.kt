package com.iagoaf.nutrichef.src.auth.infra.inject

import com.iagoaf.nutrichef.src.auth.external.service.AuthServiceImpl
import com.iagoaf.nutrichef.src.auth.infra.service.IAuthService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthServiceModule {
    @Binds
    @Singleton
    abstract fun bindAuthService(
        impl: AuthServiceImpl
    ): IAuthService
}
