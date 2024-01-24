package com.example.capitales.countryList

import com.example.capitales.Country
import com.example.capitales.api.CountriesApi.retrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CountryRepository {
    suspend fun downloadCountries(): List<Country> {
       return withContext(Dispatchers.IO) {
            retrofitService.getAllCountries()
       }
    }


}