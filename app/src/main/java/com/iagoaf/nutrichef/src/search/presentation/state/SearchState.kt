package com.iagoaf.nutrichef.src.search.presentation.state

import com.iagoaf.nutrichef.src.home.domain.model.DishModel

sealed class SearchState {
    object Idle : SearchState()
    object Loading : SearchState()
    data class Success(val dishes: List<DishModel>) : SearchState()
}