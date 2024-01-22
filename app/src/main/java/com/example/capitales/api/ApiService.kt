package com.example.capitales.api
import com.example.capitales.BASE_URL
import com.example.capitales.Country
import com.example.capitales.GET_ALL_COUNTRIES
import com.example.capitales.api.responses.CountryListApiResponse
import com.example.capitales.api.responses.CountryListResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

interface ApiService{
    @GET(GET_ALL_COUNTRIES)
    suspend fun getAllCountries(): List<Country>
}

object CountriesApi{
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}