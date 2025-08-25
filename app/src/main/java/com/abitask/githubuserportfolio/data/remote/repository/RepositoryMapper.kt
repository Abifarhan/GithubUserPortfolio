package com.abitask.githubuserportfolio.data.remote.repository

import com.abitask.githubuserportfolio.data.local.dao.UserEntity
import com.abitask.githubuserportfolio.data.remote.dto.UserDetailDto
import com.abitask.githubuserportfolio.data.remote.dto.UserDto
import com.abitask.githubuserportfolio.domain.model.User

fun UserDto.toEntity(): UserEntity = UserEntity(
    id = id ?: 0,
    login = login ?: "",
    avatarUrl = avatarUrl ?: ""
)

fun UserDto.toDomain(): User {
    return User(
        id = id ?: 0,
        login = login.orEmpty(),
        avatarUrl = avatarUrl.orEmpty(),
        nodeId = null,
        htmlUrl = null
    )
}

fun UserDetailDto.toDomain(): User {
    return User(
        id = id ?: 0,
        login = login.orEmpty(),
        avatarUrl = avatarUrl.orEmpty(),
        nodeId = publicRepos,
        htmlUrl = htmlUrl
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = id,
        login = login,
        avatarUrl = avatarUrl,
        htmlUrl = htmlUrl ?: ""
    )
}

fun UserEntity.toDomain(): User {
    return User(
        id = id,
        login = login,
        avatarUrl = avatarUrl,
        htmlUrl = htmlUrl
    )
}