package com.yanytskyi.dima.netronic.data.api.dto.users_profiles

import com.google.gson.annotations.SerializedName

data class TimezoneDto(
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("offset")
    val offset: String? = null
)