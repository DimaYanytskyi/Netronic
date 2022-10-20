package com.yanytskyi.dima.netronic.presentation.screens.users

import com.yanytskyi.dima.netronic.domain.model.User

data class UsersState(
    val loading: Boolean = false,
    val data: List<User> = emptyList(),
    val message: String = ""
)
