package com.yanytskyi.dima.netronic.data.api

import com.yanytskyi.dima.netronic.data.api.dto.users_profiles.UsersDto
import retrofit2.http.GET
import retrofit2.http.Query

interface UserProfileApi {

    @GET("./")
    suspend fun fetchUsersProfiles(
        @Query("results") count: Int
    ) : UsersDto
}