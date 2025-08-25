package com.abitask.githubuserportfolio.domain.usecase

import com.abitask.githubuserportfolio.domain.model.User
import com.abitask.githubuserportfolio.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetUserDetailUseCase @Inject constructor(
    private val repo: UserRepository
) : IGetUserDetailUseCase {
    override suspend operator fun invoke(login: String): User = withContext(Dispatchers.IO) {
        repo.getUserDetail(login)
    }
}