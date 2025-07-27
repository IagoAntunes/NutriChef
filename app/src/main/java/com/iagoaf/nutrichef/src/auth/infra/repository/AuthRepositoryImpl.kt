package com.iagoaf.nutrichef.src.auth.infra.repository

import com.iagoaf.nutrichef.core.result.BaseResult
import com.iagoaf.nutrichef.services.keyvalue.PreferencesManager
import com.iagoaf.nutrichef.src.auth.domain.model.AuthUserModel
import com.iagoaf.nutrichef.src.auth.domain.model.UserModel
import com.iagoaf.nutrichef.src.auth.domain.repository.IAuthRepository
import com.iagoaf.nutrichef.src.auth.infra.service.IAuthService
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    val authService: IAuthService,
    val preferencesManager: PreferencesManager,
) : IAuthRepository {
    override suspend fun login(
        email: String,
        password: String
    ): BaseResult<UserModel> {
        val result = authService.login(email, password)

        return when (result) {
            is BaseResult.Success -> {
                val userInfoResult = authService.getUserInfo(result.data.uid)
                when (userInfoResult) {
                    is BaseResult.Success -> BaseResult.Success(userInfoResult.data)
                    is BaseResult.Error -> BaseResult.Error(userInfoResult.message)
                }
            }
            is BaseResult.Error -> BaseResult.Error(result.message)
        }
    }


    override suspend fun register(
        name: String,
        email: String,
        password: String
    ): BaseResult<AuthUserModel> {
        val result = authService.register(email, password)
        result.onSuccess { authUser ->
            val user = UserModel(
                uid = authUser.uid,
                name = name,
                email = authUser.email,
            )
            authService.createUserDatabase(
                authUser.uid,
                user
            )
        }
        return result
    }

    override suspend fun isUserLogged(): BaseResult<AuthUserModel> {
        val result = authService.getCurrentUser()
        result.onSuccess { authUser ->
            val result2 = authService.getUserInfo(authUser.uid)
            result2.onSuccess { userDetails ->
                preferencesManager.set("user_email", authUser.email)
                preferencesManager.set("user_name", userDetails.name)
                preferencesManager.set("user_uid", authUser.uid)
            }
            result.onError {
                preferencesManager.set("user_email", authUser.email)
                preferencesManager.set("user_uid", authUser.uid)
            }
        }
        return result
    }

    override suspend fun signOut(): BaseResult<Unit> {
        return authService.signOut()
    }
}