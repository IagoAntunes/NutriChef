package com.iagoaf.nutrichef.src.home.external.service

import com.google.firebase.firestore.FirebaseFirestore
import com.iagoaf.nutrichef.core.result.BaseResult
import com.iagoaf.nutrichef.src.home.domain.model.DishModel
import com.iagoaf.nutrichef.src.home.infra.service.IDishService
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class DishServiceImpl @Inject constructor() : IDishService {
    val firestore = FirebaseFirestore.getInstance()

    override suspend fun getDishes(): BaseResult<List<DishModel>> {
        try {
            val result = firestore.collection("dishes").get().await()
            val dishes = result.toObjects(DishModel::class.java)
            return BaseResult.Success(dishes)
        } catch (e: Exception) {
            return BaseResult.Error(e.message ?: "Unknown error")
        }
    }
}