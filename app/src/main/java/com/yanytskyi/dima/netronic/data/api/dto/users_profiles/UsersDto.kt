package com.yanytskyi.dima.netronic.data.api.dto.users_profiles

import com.google.gson.annotations.SerializedName
import com.yanytskyi.dima.netronic.domain.model.User

data class UsersDto(
    @SerializedName("results")
    val userDtos: List<UserDto?>?,
    @SerializedName("info")
    val infoDto: InfoDto?
)

fun UsersDto.toDomain() : List<User> {
    return if(userDtos != null) {
        val userList = mutableListOf<User>()
        userDtos.forEach {
            userList.add(
                User(
                    it?.nameDto?.first ?: "",
                    it?.nameDto?.last ?: "",
                    it?.loginDto?.username ?: "",
                    it?.email ?: "",
                    it?.locationDto?.country ?: "",
                    it?.pictureDto?.thumbnail ?: ""
                )
            )
        }
        userList.toList()
    } else {
        emptyList()
    }
}