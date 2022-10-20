package com.yanytskyi.dima.netronic.data.repository

import com.yanytskyi.dima.netronic.data.ResultWrapper
import com.yanytskyi.dima.netronic.data.api.UserProfileApi
import com.yanytskyi.dima.netronic.data.api.dto.users_profiles.toDomain
import com.yanytskyi.dima.netronic.data.database.dao.UserProfileDao
import com.yanytskyi.dima.netronic.data.database.model.toDomain
import com.yanytskyi.dima.netronic.domain.model.User
import com.yanytskyi.dima.netronic.domain.model.toDbEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class UserProfilesRepository @Inject constructor(
    private val userProfileDao: UserProfileDao,
    private val userProfileApi: UserProfileApi
) : IUserProfilesRepository{

    override suspend fun loadUsersProfiles(): Flow<ResultWrapper<List<User>>> = flow {
        try {
            emit(ResultWrapper.Loading())
            val loadedProfiles = userProfileDao.loadProfilesHistory().map { it.toDomain() }.reversed()
            emit(ResultWrapper.Success(loadedProfiles))
        } catch (e: Exception) {
            emit(ResultWrapper.Error(e.message ?: e.toString()))
        }
    }

    override suspend fun fetchUsersProfiles(count: Int): Flow<ResultWrapper<List<User>>> = flow {
        try {
            emit(ResultWrapper.Loading())
            val fetchedProfiles = userProfileApi.fetchUsersProfiles(count).toDomain()
            userProfileDao.insertUsersProfiles(fetchedProfiles.map { it.toDbEntity() })
            emit(ResultWrapper.Success(fetchedProfiles))
        } catch (e: Exception) {
            emit(ResultWrapper.Error(e.message ?: e.toString()))
        }
    }

}