package com.example.capitales.countryDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.capitales.CoatOfArms
import com.example.capitales.Country
import com.example.capitales.Flags
import com.example.capitales.Maps
import com.example.capitales.R
import com.example.capitales.Translation
import com.example.capitales.api.dto.CoatOfArms
import com.example.capitales.api.dto.CountryName
import com.example.capitales.api.dto.Flags
import com.example.capitales.api.dto.Maps
import com.example.capitales.api.dto.Translation
import kotlinx.parcelize.RawValue

@Composable
fun CountryDetailScreen() {
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.secondary_background))
            .padding(start = 8.dp, end = 8.dp, bottom = 16.dp),
        contentAlignment = Alignment.TopCenter
    ){//Layout para poner cosas adentro
        val country = Country(
        val fifa:String?,
        val name: common,
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
        val maps: @RawValue Maps)
        CountryInformation(country)

    }
}

@Composable
fun CountryInformation(country: Country) {
    TODO("Not yet implemented")
}
