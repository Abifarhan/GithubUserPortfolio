package com.abitask.githubuserportfolio.domain.usecase

import com.abitask.githubuserportfolio.domain.model.User

interface ISearchUsersUseCase {
    suspend operator fun invoke(q: String): List<User>
}