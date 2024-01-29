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
    val area:Float,
    val flag: String,
    val flags: @RawValue Flags,
    val region: String,
    val subregion: String?,
    val translations: @RawValue Translation,
    val population: Long,
    val startOfWeek: String,
    val borders: @RawValue List<String>?,
    val continents: @RawValue List<String>,
    val coatOfArms: @RawValue CoatOfArms,
    val maps: @RawValue Maps
) : Parcelable


@Parcelize
data class CountryName(
    val common: String,
    val official: String
) : Parcelable

@Parcelize
data class Maps(
  val googleMaps: String
) : Parcelable

@Parcelize
data class CoatOfArms(
    val png: String?
): Parcelable
@Parcelize
data class Flags(
    val png: String
): Parcelable
@Parcelize
data class Translation(
    val spa: LanguageTranslation
) : Parcelable

@Parcelize
data class LanguageTranslation(
    val official: String
) : Parcelable
