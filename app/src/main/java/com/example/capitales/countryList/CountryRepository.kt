package com.example.capitales.countryList

import com.example.capitales.Country
import com.example.capitales.api.ApiResponseStatus
import com.example.capitales.api.CountriesApi.retrofitService
import com.example.capitales.api.makeNetworkCall

class CountryRepository { // deja de devolver unicamente los countries, ahora devuelve tambien el estado
    suspend fun downloadCountries(): ApiResponseStatus<List<Country>>
            = makeNetworkCall {
        retrofitService.getAllCountries().sorted()
    }
    suspend fun downloadCountry(countryName: String): ApiResponseStatus<Country>
            = makeNetworkCall {
            retrofitService.searchCountry(countryName)
    }



}