package com.yanytskyi.dima.netronic.data.api.dto.users_profiles

import com.google.gson.annotations.SerializedName

data class CoordinatesDto(
    @SerializedName("latitude")
    val latitude: String? = null,
    @SerializedName("longitude")
    val longitude: String? = null
)