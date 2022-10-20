package com.yanytskyi.dima.netronic.presentation.screens.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yanytskyi.dima.netronic.data.ResultWrapper
import com.yanytskyi.dima.netronic.domain.interactor.user_profile.IUserProfileInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val userProfileInteractor: IUserProfileInteractor
) : ViewModel() {

    private val _historyState = MutableStateFlow(HistoryState())
    val historyState: StateFlow<HistoryState> = _historyState

    init {
        getUsersProfiles()
    }

    private fun getUsersProfiles() {
        viewModelScope.launch {
            userProfileInteractor.loadUsersProfiles().collect { result ->
                when(result) {
                    is ResultWrapper.Loading -> {
                        _historyState.value = HistoryState(
                            loading = true
                        )
                    }
                    is ResultWrapper.Success -> {
                        _historyState.value = HistoryState(
                            data = result.data ?: emptyList()
                        )
                    }
                    is ResultWrapper.Error -> {
                        _historyState.value = HistoryState(
                            message = result.message ?: "An unexpected error was occurred"
                        )
                    }
                }
            }
        }
    }
}