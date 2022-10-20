package com.yanytskyi.dima.netronic.data.api.dto.users_profiles

import com.google.gson.annotations.SerializedName

data class StreetDto(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("number")
    val number: Int? = null
)