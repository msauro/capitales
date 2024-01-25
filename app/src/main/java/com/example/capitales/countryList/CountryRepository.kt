package com.example.capitales.countryList

import com.example.capitales.Country
import com.example.capitales.api.ApiResponseStatus
import com.example.capitales.api.CountriesApi.retrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CountryRepository { // deja de devolver unicamente los countries, ahora devuelve tambien el estado
    suspend fun downloadCountries(): ApiResponseStatus {
       return withContext(Dispatchers.IO) {
           try {
               ApiResponseStatus.Success(retrofitService.getAllCountries())
           } catch (e: Exception){
               ApiResponseStatus.Error("Error descargando datos")
           }
       }
    }


}