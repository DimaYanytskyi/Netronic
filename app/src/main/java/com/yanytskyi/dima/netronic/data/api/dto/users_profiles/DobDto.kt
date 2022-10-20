package com.yanytskyi.dima.netronic.data.api.dto.users_profiles

import com.google.gson.annotations.SerializedName

data class DobDto(
    @SerializedName("age")
    val age: Int? = null,
    @SerializedName("date")
    val date: String? = null
)