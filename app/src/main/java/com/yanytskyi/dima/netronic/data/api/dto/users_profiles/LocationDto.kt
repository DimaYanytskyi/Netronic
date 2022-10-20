package com.yanytskyi.dima.netronic.data.api.dto.users_profiles

import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("coordinates")
    val coordinatesDto: CoordinatesDto? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("postcode")
    val postcode: String? = null,
    @SerializedName("state")
    val state: String? = null,
    @SerializedName("street")
    val streetDto: StreetDto? = null,
    @SerializedName("timezone")
    val timezoneDto: TimezoneDto? = null
)