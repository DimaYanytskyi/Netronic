package com.yanytskyi.dima.netronic.presentation.screens.users

sealed class UsersScreenEvent {
    data class OnCountChanged(val count: Int) : UsersScreenEvent()
    object GetUsers : UsersScreenEvent()
}
