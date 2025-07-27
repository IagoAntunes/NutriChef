package com.iagoaf.nutrichef.src.auth.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iagoaf.nutrichef.src.auth.domain.repository.IAuthRepository
import com.iagoaf.nutrichef.src.auth.presentation.LoginState
import com.iagoaf.nutrichef.src.auth.presentation.state.LoginListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val authRepository: IAuthRepository
) : ViewModel() {

    private val _state =
        MutableStateFlow<LoginState>(LoginState.Idle(isLogin = true, isLoading = false))
    val state = _state.asStateFlow()

    private val _listener = MutableStateFlow<LoginListener>(LoginListener.Idle)
    val listener: StateFlow<LoginListener> = _listener.asStateFlow()

    fun login(email: String, password: String, onEnd: () -> Unit) {
        viewModelScope.launch {
            _state.value = LoginState.Idle(isLogin = true, isLoading = true)
            authRepository.login(email, password).onSuccess {
                _state.value = LoginState.Idle(isLogin = true, isLoading = false)
                _listener.value = LoginListener.OnLoginSuccess
                onEnd()
            }.onError {
                _state.value = LoginState.Idle(isLogin = true, isLoading = false)
            }
        }
    }

    fun register(name: String, email: String, password: String) {
        _state.value = LoginState.Idle(isLogin = false, isLoading = true)
        viewModelScope.launch {
            val result = authRepository.register(name, email, password)
            result.onSuccess {
                _state.value = LoginState.Idle(isLogin = true, isLoading = false)
            }
            result.onError {
                _state.value = LoginState.Idle(isLogin = false, isLoading = false)
            }
        }
    }

    fun changeAuthMode(isLogin: Boolean) {
        _state.value = LoginState.Idle(isLogin = isLogin, isLoading = false)
    }


}