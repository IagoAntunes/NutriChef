package com.iagoaf.nutrichef.src.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.iagoaf.nutrichef.core.utils.DishSamples
import com.iagoaf.nutrichef.services.keyvalue.PreferencesManager
import com.iagoaf.nutrichef.src.home.domain.repository.IDishRepository
import com.iagoaf.nutrichef.src.home.presentation.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val preferencesManager: PreferencesManager,
    val dishRepository: IDishRepository
) : ViewModel() {

    private val _state = MutableStateFlow<HomeState>(HomeState.Idle("", emptyList(), emptyList()))
    val state = _state.asStateFlow()


    init {
        getUserData()
        getDishes()
    }

    fun getUserData() {
        val userName = preferencesManager.get("user_name")
        _state.value = HomeState.Idle(userName!!, emptyList(), emptyList())
    }

    fun getDishes() {
        viewModelScope.launch {
            val result = dishRepository.getDishes()
            result.onSuccess {
                val name = (_state.value as HomeState.Idle).name
                val auxHeadDishes = it.filter { dish -> dish.category == "health" }
                val auxSubDishes = it.filter { dish -> dish.category == "principal" }

                _state.value = HomeState.Idle(
                    name = name,
                    headDishes = auxHeadDishes,
                    subDishes = auxSubDishes,
                )
            }.onError {

            }
        }
    }

    fun createDishes() {
        viewModelScope.launch {
            val firestore = FirebaseFirestore.getInstance()

            DishSamples.dishes.forEach { dish ->
                firestore.collection("dishes")
                    .add(dish)
                    .addOnSuccessListener {
                        println("Prato '${dish.name}' adicionado com sucesso!")
                    }
                    .addOnFailureListener { e ->
                        println("Erro ao adicionar '${dish.name}': ${e.message}")
                    }
            }
        }
    }


}