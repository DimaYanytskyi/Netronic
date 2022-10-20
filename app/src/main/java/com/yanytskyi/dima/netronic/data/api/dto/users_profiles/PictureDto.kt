package com.yanytskyi.dima.netronic.data.api.dto.users_profiles

import com.google.gson.annotations.SerializedName

data class PictureDto(
    @SerializedName("large")
    val large: String? = null,
    @SerializedName("medium")
    val medium: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: String? = null
)