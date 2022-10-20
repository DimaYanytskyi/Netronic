package com.yanytskyi.dima.netronic.presentation.screens.history

import com.yanytskyi.dima.netronic.domain.model.User

data class HistoryState(
    val loading: Boolean = false,
    val data: List<User> = emptyList(),
    val message: String = ""
)
