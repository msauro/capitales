package com.example.capitales.api.responses

import com.example.capitales.Country
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CountryListResponse(
    @Json(name = "")
    val countries: List<Country>

)