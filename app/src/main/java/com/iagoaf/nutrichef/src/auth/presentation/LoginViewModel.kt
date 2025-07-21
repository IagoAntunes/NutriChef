package com.iagoaf.nutrichef.src.auth.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {

    private val _state = MutableStateFlow<LoginState>(LoginState.Idle(isLogin = true))
    val state = _state.asStateFlow()

}