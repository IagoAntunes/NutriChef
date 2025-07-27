package com.iagoaf.nutrichef.src.auth.domain.repository

import com.iagoaf.nutrichef.core.result.BaseResult
import com.iagoaf.nutrichef.src.auth.domain.model.AuthUserModel
import com.iagoaf.nutrichef.src.auth.domain.model.UserModel

interface IAuthRepository {
    suspend fun login(email: String, password: String): BaseResult<UserModel>
    suspend fun register(name: String, email: String, password: String): BaseResult<AuthUserModel>
    suspend fun isUserLogged(): BaseResult<AuthUserModel>
    suspend fun signOut(): BaseResult<Unit>
}