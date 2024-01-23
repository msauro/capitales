package com.example.capitales

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Country (
    val fifa:String?,
    val name: CountryName,
    val area:Double,
    val flag: String,
    val region: String,
    @field:Json(name = "translations") val translations: Translation,
    val population: Long,
    val maps: Maps
)

data class CountryName(
    val common: String,
    val official: String
)
data class Maps(
  val googleMaps: String
)


data class Translation(
    val spa: LanguageTranslation
)

data class LanguageTranslation(
    val official: String
)
