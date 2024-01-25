package com.example.capitales.api

import android.os.Message
import com.example.capitales.Country

sealed class ApiResponseStatus() {
    class Success (val countryList: List<Country>): ApiResponseStatus()
    class Loading (): ApiResponseStatus()
    class Error (val message: String): ApiResponseStatus()
}