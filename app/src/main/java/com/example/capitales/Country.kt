package com.example.capitales

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
@JsonClass(generateAdapter = true)
data class Country (
    val fifa:String?,
    val name: @RawValue CountryName,
    val area:Double,
    val flag: String,
    val flags: @RawValue Flags,
    val region: String,
    val subregion: String?,
    val translations: @RawValue Translation,
    val population: Long,
    val borders: @RawValue List<String>?,
    val maps: @RawValue Maps
) : Parcelable

data class CountryName(
    val common: String,
    val official: String
)
data class Maps(
  val googleMaps: String
)

data class Flags(
    val png: String
)

data class Translation(
    val spa: LanguageTranslation
)

data class LanguageTranslation(
    val official: String
)
