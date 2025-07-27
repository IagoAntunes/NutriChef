package com.iagoaf.nutrichef.src.auth.presentation

sealed class LoginState(open val isLogin: Boolean, open val isLoading: Boolean) {
    data class Idle(override val isLogin: Boolean = true, override val isLoading: Boolean) :
        LoginState(isLogin = isLogin, isLoading = isLoading)
}
