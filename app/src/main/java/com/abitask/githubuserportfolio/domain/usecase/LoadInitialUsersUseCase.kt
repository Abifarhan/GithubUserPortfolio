package com.abitask.githubuserportfolio.domain.usecase

import com.abitask.githubuserportfolio.domain.model.User
import com.abitask.githubuserportfolio.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoadInitialUsersUseCase @Inject constructor(
    private val repo: UserRepository
) : ILoadInitialUsersUseCase {

    override suspend operator fun invoke(): List<User> = withContext(Dispatchers.IO) {
        val cached = repo.observeCachedUsers().first()
        if (cached.isNotEmpty()) return@withContext cached
        val remote = repo.getDefaultUsers()
        repo.cacheUsers(remote)
        remote
    }
}