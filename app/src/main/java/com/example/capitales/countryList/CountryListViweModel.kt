package com.example.capitales.countryList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capitales.Country
import kotlinx.coroutines.launch

class CountryListViewModel: ViewModel() {

    private  val _countryList = MutableLiveData<List<Country>>()
    val countryList: LiveData<List<Country>>
        get()=_countryList

    private val countryRepository = CountryRepository()
    init {
        downloadCountries()
    }
    private fun downloadCountries(){
        viewModelScope.launch {
            _countryList.value = countryRepository.downloadCountries()

        }
    }
}