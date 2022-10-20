package com.yanytskyi.dima.netronic.domain.model

import android.os.Parcelable
import com.yanytskyi.dima.netronic.data.database.model.UserDb
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val firstName: String,
    val secondName: String,
    val username: String,
    val email: String,
    val country: String,
    val thumbnailUrl: String
) : Parcelable

fun User.toDbEntity() : UserDb {
    return UserDb(
        firstName = firstName,
        secondName = secondName,
        username = username,
        email = email,
        country = country,
        thumbnailUrl = thumbnailUrl
    )
}
