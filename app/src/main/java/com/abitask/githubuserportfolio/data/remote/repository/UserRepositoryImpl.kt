package com.abitask.githubuserportfolio.data.remote.repository

import com.abitask.githubuserportfolio.data.local.dao.UserDao
import com.abitask.githubuserportfolio.data.remote.api.GitHubApiService
import com.abitask.githubuserportfolio.domain.model.User
import com.abitask.githubuserportfolio.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: GitHubApiService,
    private val dao: UserDao
) : UserRepository {

    override fun observeCachedUsers(): Flow<List<User>> =
        dao.observeAllLimited(50).map { it.map { entity -> entity.toDomain() } }

    override suspend fun getDefaultUsers(): List<User> {
        val cached = dao.observeAllLimited(50).first()
        if (cached.isNotEmpty()) return cached.map { it.toDomain() }

        val remote = api.getUsers()
        val domain = remote.map { it.toDomain() }

        dao.insertAll(remote.map { it.toEntity() })

        return domain
    }

    override suspend fun searchUsers(q: String): List<User> {
        val resp = api.searchUsers(q)
        val domain = resp.items?.map { it.toDomain() }

        dao.insertAll(resp.items?.map { it.toEntity() } ?: emptyList())
        return domain ?: emptyList()
    }

    override suspend fun getUserDetail(login: String): User {
        val remote = api.getUserDetail(login).toDomain()
        dao.insert(remote.toEntity())
        return remote
    }

    override suspend fun cacheUsers(users: List<User>) {
        dao.insertAll(users.map { it.toEntity() })
    }
}



