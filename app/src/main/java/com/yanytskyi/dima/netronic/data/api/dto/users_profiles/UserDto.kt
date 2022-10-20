package com.yanytskyi.dima.netronic.data.api.dto.users_profiles

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("cell")
    val cell: String? = null,
    @SerializedName("dob")
    val dobDto: DobDto? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("id")
    val idDto: IdDto? = null,
    @SerializedName("location")
    val locationDto: LocationDto? = null,
    @SerializedName("login")
    val loginDto: LoginDto? = null,
    @SerializedName("name")
    val nameDto: NameDto? = null,
    @SerializedName("nat")
    val nat: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("picture")
    val pictureDto: PictureDto? = null,
    @SerializedName("registered")
    val registeredDto: RegisteredDto? = null
)