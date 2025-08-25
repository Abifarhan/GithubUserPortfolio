package com.abitask.githubuserportfolio.domain.usecase

import com.abitask.githubuserportfolio.domain.model.User

interface ILoadInitialUsersUseCase {
    suspend operator fun invoke(): List<User>
}
