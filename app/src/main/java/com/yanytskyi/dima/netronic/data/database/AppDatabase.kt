package com.yanytskyi.dima.netronic.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yanytskyi.dima.netronic.data.database.dao.UserProfileDao
import com.yanytskyi.dima.netronic.data.database.model.UserDb

@Database(
    entities = [
        UserDb::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun profilesDao(): UserProfileDao
}