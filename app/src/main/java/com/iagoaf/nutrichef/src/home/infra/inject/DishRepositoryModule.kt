package com.iagoaf.nutrichef.src.home.infra.inject

import com.iagoaf.nutrichef.src.home.domain.repository.IDishRepository
import com.iagoaf.nutrichef.src.home.infra.repository.DishRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DishRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindDishRepository(
        impl: DishRepositoryImpl
    ): IDishRepository
}
