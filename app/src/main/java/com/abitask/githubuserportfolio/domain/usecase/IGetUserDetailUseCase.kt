package com.abitask.githubuserportfolio.domain.usecase

import com.abitask.githubuserportfolio.domain.model.User

interface IGetUserDetailUseCase {
    suspend operator fun invoke(login: String): User
}