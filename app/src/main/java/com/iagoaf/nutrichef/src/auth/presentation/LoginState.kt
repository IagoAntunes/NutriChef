package com.iagoaf.nutrichef.src.auth.presentation

sealed class LoginState(open val isLogin: Boolean) {
    data class Idle(override val isLogin: Boolean = true) : LoginState(isLogin = isLogin)
}
