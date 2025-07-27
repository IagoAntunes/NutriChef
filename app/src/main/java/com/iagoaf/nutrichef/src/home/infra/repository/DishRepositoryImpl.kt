package com.iagoaf.nutrichef.src.home.infra.repository

import com.iagoaf.nutrichef.core.result.BaseResult
import com.iagoaf.nutrichef.src.home.domain.model.DishModel
import com.iagoaf.nutrichef.src.home.domain.repository.IDishRepository
import com.iagoaf.nutrichef.src.home.infra.service.IDishService
import javax.inject.Inject

class DishRepositoryImpl @Inject constructor(
    val dishService: IDishService
) : IDishRepository {
    override suspend fun getDishes(): BaseResult<List<DishModel>> {
        return dishService.getDishes()
    }
}