package com.abitask.githubuserportfolio.data.remote.api

import com.abitask.githubuserportfolio.data.remote.dto.SearchResponseDto
import com.abitask.githubuserportfolio.data.remote.dto.UserDetailDto
import com.abitask.githubuserportfolio.data.remote.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApiService {

    @GET("search/users")
    suspend fun searchUsers(@Query("q") q: String): SearchResponseDto

    @GET("users")
    suspend fun getUsers(): List<UserDto>

    @GET("users/{login}")
    suspend fun getUserDetail(@Path("login") login: String): UserDetailDto
}