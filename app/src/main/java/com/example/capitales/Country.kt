package com.example.capitales

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Country(
    val fifa:String?,
    val name: String,
    val area:Float,
    val flag: String,
    val flags: String,
    val region: String,
    val subregion: String?,
    val translations: String,
    val population: Long,
    val startOfWeek: String,
    val borders: List<String>?,
    val continents: List<String>,
    val coatOfArms: String?,
    val maps: String
) : Parcelable, Comparable<Country>{
    override fun compareTo(other: Country): Int {
        return if (this.name > other.name) {
            1
        }else{
            -1
        }
    }

}
