package com.iagoaf.nutrichef.src.search.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iagoaf.nutrichef.src.home.domain.model.DishModel
import com.iagoaf.nutrichef.src.home.domain.repository.IDishRepository
import com.iagoaf.nutrichef.src.search.presentation.state.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    val dishRepository: IDishRepository
) : ViewModel() {

    private val _state = MutableStateFlow<SearchState>(SearchState.Idle)
    val state = _state.asStateFlow()

    private var dishes = emptyList<DishModel>()

    init {
        getDishes()
    }

    fun getDishes() {
        _state.value = SearchState.Loading
        viewModelScope.launch {
            val result = dishRepository.getDishes()
            result.onSuccess {
                dishes = it
                _state.value = SearchState.Success(it)
            }
            result.onError {
                //
            }
        }
    }

    fun filter(name: String) {
        val filteredDishes = dishes.filter { dish ->
            dish.name.contains(name, ignoreCase = true)
        }
        _state.value = SearchState.Success(filteredDishes)
    }


}