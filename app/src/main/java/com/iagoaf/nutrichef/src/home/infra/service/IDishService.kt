package com.iagoaf.nutrichef.src.home.infra.service

import com.iagoaf.nutrichef.core.result.BaseResult
import com.iagoaf.nutrichef.src.home.domain.model.DishModel

interface IDishService {
    suspend fun getDishes(): BaseResult<List<DishModel>>
}