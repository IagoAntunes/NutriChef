package com.iagoaf.nutrichef.src.home.presentation.state

import com.iagoaf.nutrichef.src.home.domain.model.DishModel

sealed class HomeState {
    data class Idle(
        val name: String,
        val headDishes: List<DishModel>,
        val subDishes: List<DishModel>,
    ) : HomeState()
}