package com.iagoaf.nutrichef.src.auth.presentation.state

sealed class AuthState {
    object Initial : AuthState()
    object Loading : AuthState()
}