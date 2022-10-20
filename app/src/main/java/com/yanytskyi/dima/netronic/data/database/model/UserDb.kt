package com.yanytskyi.dima.netronic.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yanytskyi.dima.netronic.domain.model.User

@Entity
data class UserDb(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    val firstName: String?,
    val secondName: String?,
    val username: String?,
    val email: String?,
    val country: String?,
    val thumbnailUrl: String?
)

fun UserDb.toDomain() : User {
    return User(
        firstName ?: "",
        secondName ?: "",
        username ?: "",
        email ?: "",
        country ?: "",
        thumbnailUrl ?: "",
    )
}
