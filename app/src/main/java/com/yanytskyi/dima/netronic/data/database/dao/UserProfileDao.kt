package com.yanytskyi.dima.netronic.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yanytskyi.dima.netronic.data.database.model.UserDb

@Dao
interface UserProfileDao {

    @Query("SELECT * FROM UserDb")
    suspend fun loadProfilesHistory() : List<UserDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsersProfiles(profiles: List<UserDb>)
}