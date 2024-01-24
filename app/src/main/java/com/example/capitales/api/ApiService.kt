package com.example.capitales.api
import com.example.capitales.BASE_URL
import com.example.capitales.Country
import com.example.capitales.GET_ALL_COUNTRIES
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
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