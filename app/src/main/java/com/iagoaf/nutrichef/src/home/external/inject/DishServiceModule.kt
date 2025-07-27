package com.iagoaf.nutrichef.src.home.external.inject

import com.iagoaf.nutrichef.src.home.external.service.DishServiceImpl
import com.iagoaf.nutrichef.src.home.infra.service.IDishService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DishServiceModule {
    @Binds
    @Singleton
    abstract fun bindDishService(
        impl: DishServiceImpl
    ): IDishService
}
