package com.iagoaf.nutrichef.src.auth.external.service

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.iagoaf.nutrichef.core.result.BaseResult
import com.iagoaf.nutrichef.src.auth.domain.model.AuthUserModel
import com.iagoaf.nutrichef.src.auth.domain.model.UserModel
import com.iagoaf.nutrichef.src.auth.infra.service.IAuthService
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthServiceImpl @Inject constructor() : IAuthService {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    override suspend fun login(
        email: String,
        password: String
    ): BaseResult<AuthUserModel> {
        try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            return BaseResult.Success(
                AuthUserModel(
                    uid = result.user?.uid ?: "",
                    email = result.user?.email ?: "",
                )
            )
        } catch (e: Exception) {
            return BaseResult.Error(e.message ?: "")
        }
    }

    override suspend fun register(
        email: String,
        password: String
    ): BaseResult<AuthUserModel> {
        try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val authUser = AuthUserModel(
                uid = result.user?.uid ?: "",
                email = result.user?.email ?: ""
            )
            return BaseResult.Success(authUser)
        } catch (e: Exception) {
            return BaseResult.Error(e.message ?: "Unknown error")
        }
    }

    override suspend fun createUserDatabase(
        userId: String,
        user: UserModel
    ): BaseResult<Unit> {
        try {
            firestore.collection("users").document(userId).set(user).await()
            return BaseResult.Success(Unit)
        } catch (e: Exception) {
            return BaseResult.Error(e.message ?: "Unknown error")
        }
    }

    override suspend fun getCurrentUser(): BaseResult<AuthUserModel> {
        try {
            val firebaseUser = auth.currentUser
            val user = AuthUserModel(
                uid = firebaseUser?.uid ?: "",
                email = firebaseUser?.email ?: "",
            )
            return BaseResult.Success(user)
        } catch (e: Exception) {
            return BaseResult.Error(e.message.toString())
        }
    }

    override suspend fun getUserInfo(userId: String): BaseResult<UserModel> {
        try {
            val result = firestore.collection("users").document(userId).get().await()
            val user = result.toObject(UserModel::class.java)!!
            return BaseResult.Success(user)
        } catch (e: Exception) {
            return BaseResult.Error(e.message ?: "")
        }
    }

    override suspend fun signOut(): BaseResult<Unit> {
        try {
            auth.signOut()
            return BaseResult.Success(Unit)
        } catch (e: Exception) {
            return BaseResult.Error(e.message ?: "")
        }
    }
}