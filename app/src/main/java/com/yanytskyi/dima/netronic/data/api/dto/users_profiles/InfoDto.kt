package com.yanytskyi.dima.netronic.data.api.dto.users_profiles

import com.google.gson.annotations.SerializedName

data class InfoDto(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: Int? = null,
    @SerializedName("seed")
    val seed: String? = null,
    @SerializedName("version")
    val version: String? = null
)