package com.abitask.githubuserportfolio.domain.usecase

import com.abitask.githubuserportfolio.domain.model.User
import com.abitask.githubuserportfolio.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchUsersUseCase @Inject constructor(
    private val repo: UserRepository
) : ISearchUsersUseCase {
    override suspend operator fun invoke(q: String): List<User> = withContext(Dispatchers.IO) {
        val result = repo.searchUsers(q)
        repo.cacheUsers(result)
        result
    }
}