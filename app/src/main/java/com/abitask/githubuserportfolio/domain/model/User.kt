package com.abitask.githubuserportfolio.domain.model

data class User(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val nodeId: String? = null,
    val htmlUrl: String? = null
)