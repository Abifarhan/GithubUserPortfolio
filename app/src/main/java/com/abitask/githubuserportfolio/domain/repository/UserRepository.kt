package com.abitask.githubuserportfolio.domain.repository

import com.abitask.githubuserportfolio.domain.model.User
import kotlinx.coroutines.flow.Flow


interface UserRepository {
    fun observeCachedUsers(): Flow<List<User>>
    suspend fun getDefaultUsers(): List<User>
    suspend fun searchUsers(q: String): List<User>
    suspend fun getUserDetail(login: String): User
    suspend fun cacheUsers(users: List<User>)
}