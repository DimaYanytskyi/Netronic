package com.yanytskyi.dima.netronic.data.api.dto.users_profiles

import com.google.gson.annotations.SerializedName

data class NameDto(
    @SerializedName("first")
    val first: String? = null,
    @SerializedName("last")
    val last: String? = null,
    @SerializedName("title")
    val title: String? = null
)