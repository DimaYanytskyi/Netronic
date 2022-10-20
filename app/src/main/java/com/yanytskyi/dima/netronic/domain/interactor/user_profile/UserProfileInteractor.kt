package com.yanytskyi.dima.netronic.domain.interactor.user_profile

import com.yanytskyi.dima.netronic.data.ResultWrapper
import com.yanytskyi.dima.netronic.data.api.dto.users_profiles.toDomain
import com.yanytskyi.dima.netronic.data.database.model.toDomain
import com.yanytskyi.dima.netronic.data.repository.IUserProfilesRepository
import com.yanytskyi.dima.netronic.domain.model.User
import com.yanytskyi.dima.netronic.domain.model.toDbEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.lang.Exception
import javax.inject.Inject

class UserProfileInteractor @Inject constructor(
    private val userProfilesRepository: IUserProfilesRepository
) : IUserProfileInteractor {

    override suspend fun loadUsersProfiles() : Flow<ResultWrapper<List<User>>> {
        return userProfilesRepository.loadUsersProfiles()
    }

    override suspend fun fetchUsersProfiles(count: Int) : Flow<ResultWrapper<List<User>>> {
        return userProfilesRepository.fetchUsersProfiles(count)
    }

}