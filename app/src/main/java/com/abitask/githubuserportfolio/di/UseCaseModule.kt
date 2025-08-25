package com.abitask.githubuserportfolio.di

import com.abitask.githubuserportfolio.domain.usecase.GetUserDetailUseCase
import com.abitask.githubuserportfolio.domain.usecase.IGetUserDetailUseCase
import com.abitask.githubuserportfolio.domain.usecase.ILoadInitialUsersUseCase
import com.abitask.githubuserportfolio.domain.usecase.ISearchUsersUseCase
import com.abitask.githubuserportfolio.domain.usecase.LoadInitialUsersUseCase
import com.abitask.githubuserportfolio.domain.usecase.SearchUsersUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindLoadInitialUsersUseCase(
        impl: LoadInitialUsersUseCase
    ): ILoadInitialUsersUseCase

    @Binds
    abstract fun bindSearchUsersUseCase(
        impl: SearchUsersUseCase
    ): ISearchUsersUseCase

    @Binds
    abstract fun bindGetUserDetailUseCase(
        impl: GetUserDetailUseCase
    ): IGetUserDetailUseCase
}