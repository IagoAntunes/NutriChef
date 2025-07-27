package com.iagoaf.nutrichef.src.auth.infra.service

import com.iagoaf.nutrichef.core.result.BaseResult
import com.iagoaf.nutrichef.src.auth.domain.model.AuthUserModel
import com.iagoaf.nutrichef.src.auth.domain.model.UserModel

interface IAuthService {

    suspend fun login(
        email: String,
        password: String,
    ): BaseResult<AuthUserModel>

    suspend fun register(
        email: String,
        password: String
    ): BaseResult<AuthUserModel>

    suspend fun createUserDatabase(
        userId: String,
        user: UserModel
    ): BaseResult<Unit>

    suspend fun getCurrentUser(): BaseResult<AuthUserModel>
    suspend fun getUserInfo(userId: String): BaseResult<UserModel>
    suspend fun signOut(): BaseResult<Unit>
}