package com.abitask.githubuserportfolio.di

import com.abitask.githubuserportfolio.data.remote.repository.UserRepositoryImpl
import com.abitask.githubuserportfolio.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindUserRepo(impl: UserRepositoryImpl): UserRepository
}