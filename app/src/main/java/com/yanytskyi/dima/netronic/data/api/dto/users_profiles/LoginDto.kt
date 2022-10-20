package com.yanytskyi.dima.netronic.data.api.dto.users_profiles

import com.google.gson.annotations.SerializedName

data class LoginDto(
    @SerializedName("md5")
    val md5: String? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("salt")
    val salt: String? = null,
    @SerializedName("sha1")
    val sha1: String? = null,
    @SerializedName("sha256")
    val sha256: String? = null,
    @SerializedName("username")
    val username: String? = null,
    @SerializedName("uuid")
    val uuid: String? = null
)