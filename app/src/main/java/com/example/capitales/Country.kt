package com.example.capitales

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Country (//@field:Json(name = "fifa") val id:String,
                    val area:Int,
                   val flag: String
                    //val region: String
                    //val capital: String,
                   // val nameSpa: String,
                    //val googleMaps: String
)

