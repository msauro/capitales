package com.example.capitales.countryList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capitales.Country
import com.example.capitales.api.ApiResponseStatus
import com.example.capitales.api.dto.CountryDTO
import kotlinx.coroutines.launch

class CountryListViewModel: ViewModel() {

    private  val _countryList = MutableLiveData<List<CountryDTO>>()
    val countryList: LiveData<List<CountryDTO>>
        get()=_countryList

    private  val _status = MutableLiveData<ApiResponseStatus<List<CountryDTO>>>()
        val status: LiveData<ApiResponseStatus<List<CountryDTO>>>
        get()=_status

    private val countryRepository = CountryRepository()
    init {
        downloadCountries()
    }

    private fun downloadCountries(){
        viewModelScope.launch {
            _status.value = ApiResponseStatus.Loading()
            handleResponseStatus(countryRepository.downloadCountries())

        }
    }
    private fun handleResponseStatus(apiResponseStatus: ApiResponseStatus<List<CountryDTO>>) {
        if (apiResponseStatus is ApiResponseStatus.Success){
            _countryList.value = apiResponseStatus.data!!
        }
        _status.value = apiResponseStatus
    }

    private fun downloadCountry(countryName: String){
        viewModelScope.launch {
            _status.value = ApiResponseStatus.Loading()
           // handleResponseStatus(countryRepository.downloadCountry(countryName))
        }
    }
}