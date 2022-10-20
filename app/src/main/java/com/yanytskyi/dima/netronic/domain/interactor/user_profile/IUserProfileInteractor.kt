package com.yanytskyi.dima.netronic.domain.interactor.user_profile

import com.yanytskyi.dima.netronic.data.ResultWrapper
import com.yanytskyi.dima.netronic.domain.model.User
import kotlinx.coroutines.flow.Flow

interface IUserProfileInteractor {
    suspend fun loadUsersProfiles() : Flow<ResultWrapper<List<User>>>
    suspend fun fetchUsersProfiles(count: Int) : Flow<ResultWrapper<List<User>>>
}