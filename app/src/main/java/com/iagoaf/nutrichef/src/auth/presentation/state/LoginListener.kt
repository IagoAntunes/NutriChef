package com.iagoaf.nutrichef.src.auth.presentation.state

sealed class LoginListener{
    object Idle : LoginListener()
    object OnLoginSuccess : LoginListener()
    data class OnLoginError(val error: String) : LoginListener()
}