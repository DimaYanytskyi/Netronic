package com.yanytskyi.dima.netronic.presentation.screens.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yanytskyi.dima.netronic.data.ResultWrapper
import com.yanytskyi.dima.netronic.domain.interactor.user_profile.IUserProfileInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val userProfileInteractor: IUserProfileInteractor
) : ViewModel() {

    private val _usersState = MutableStateFlow(UsersState())
    val usersState: StateFlow<UsersState> = _usersState

    private val _countOfUsers = MutableStateFlow(1)

    private var fetchProfilesJob: Job? = null

    fun onEvent(event: UsersScreenEvent){
        when(event) {
            is UsersScreenEvent.OnCountChanged -> {
                _countOfUsers.value = event.count
            }
            is UsersScreenEvent.GetUsers -> {
                getUsersProfiles()
            }
        }
    }

    private fun getUsersProfiles() {
        fetchProfilesJob?.cancel()
        fetchProfilesJob = viewModelScope.launch {
            userProfileInteractor.fetchUsersProfiles(_countOfUsers.value ?: 1).collect { result ->
                when(result) {
                    is ResultWrapper.Loading -> {
                        _usersState.value = UsersState(
                            loading = true
                        )
                    }
                    is ResultWrapper.Success -> {
                        _usersState.value = UsersState(
                            data = result.data ?: emptyList()
                        )
                    }
                    is ResultWrapper.Error -> {
                        _usersState.value = UsersState(
                            message = result.message ?: "An unexpected error was occurred"
                        )
                    }
                }
            }
        }
    }
}