package com.abitask.githubuserportfolio.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponseDto(
    @Json(name = "items") val items: List<UserDto>?
)

@JsonClass(generateAdapter = true)
data class UserDto(
    val id: Int?,
    val login: String?,
    @Json(name = "avatar_url") val avatarUrl: String?
)

@JsonClass(generateAdapter = true)
data class UserDetailDto(
    val id: Int?,
    val login: String?,
    @Json(name = "avatar_url") val avatarUrl: String?,
    @Json(name = "node_id") val publicRepos: String?,
    @Json(name = "html_url") val htmlUrl: String?,
)