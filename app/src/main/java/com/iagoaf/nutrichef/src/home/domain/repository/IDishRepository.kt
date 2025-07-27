package com.iagoaf.nutrichef.src.home.domain.repository

import com.iagoaf.nutrichef.core.result.BaseResult
import com.iagoaf.nutrichef.src.home.domain.model.DishModel

interface IDishRepository {
    suspend fun getDishes(): BaseResult<List<DishModel>>
}