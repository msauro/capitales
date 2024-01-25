package com.example.capitales.countryList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capitales.Country
import com.example.capitales.api.ApiResponseStatus
import kotlinx.coroutines.launch

class CountryListViewModel: ViewModel() {

    private  val _countryList = MutableLiveData<List<Country>>()
    val countryList: LiveData<List<Country>>
        get()=_countryList

    private  val _status = MutableLiveData<ApiResponseStatus>()
        val status: LiveData<ApiResponseStatus>
        get()=_status

    private val countryRepository = CountryRepository()
    init {
        downloadCountries()
    }
    private fun downloadCountries(){
        viewModelScope.launch {
            _status.value = ApiResponseStatus.LOADING
            try {
                _countryList.value = countryRepository.downloadCountries()
                _status.value = ApiResponseStatus.SUCCESS

            }catch (e:Exception){
                _status.value = ApiResponseStatus.ERROR
            }

        }
    }
}