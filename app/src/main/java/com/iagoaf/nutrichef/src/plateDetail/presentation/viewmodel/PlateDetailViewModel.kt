package com.iagoaf.nutrichef.src.plateDetail.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.iagoaf.nutrichef.src.home.domain.model.DishModel
import com.iagoaf.nutrichef.src.plateDetail.presentation.state.PlateDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PlateDetailViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow<PlateDetailState>(PlateDetailState.SimpleDetails)
    val state = _state.asStateFlow()


    var dish: DishModel? = null

    fun getProteinBars(): Int {
        return calculateBars(dish?.details?.proteins ?: 0, maxValue = 30)
    }

    fun getCarbohydrateBars(): Int {
        return calculateBars(dish?.details?.carbohydrates ?: 0, maxValue = 60)
    }

    fun getSugarBars(): Int {
        return calculateBars(dish?.details?.sugar ?: 0, maxValue = 30)
    }

    fun getFatBars(): Int {
        return calculateBars(dish?.details?.fats ?: 0, maxValue = 20)
    }

    fun changeState(newState: PlateDetailState) {
        _state.value = newState
    }

    private fun calculateBars(value: Int, maxValue: Int): Int {
        val normalized = (value.toFloat() / maxValue) * 6
        return normalized.toInt().coerceIn(0, 6)
    }
}
