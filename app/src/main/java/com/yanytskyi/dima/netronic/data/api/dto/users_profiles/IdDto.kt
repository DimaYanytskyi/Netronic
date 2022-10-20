package com.yanytskyi.dima.netronic.data.api.dto.users_profiles

import com.google.gson.annotations.SerializedName

data class IdDto(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("value")
    val value: String? = null
)