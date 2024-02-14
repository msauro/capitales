package com.example.capitales.api.dto

import com.example.capitales.Country

class CountryDTOMapper {

    fun fromCountryDTOToCountryDomain(countryDTO: CountryDTO): Country{
        return Country(
            countryDTO.fifa,
            countryDTO.name.official,
            countryDTO.area,
            countryDTO.flag,
            countryDTO.maps.googleMaps,
            countryDTO.region,
            countryDTO.subregion,
            countryDTO.translations.spa.official,
            countryDTO.population,
            countryDTO.startOfWeek,
            countryDTO.borders,
            countryDTO.continents,
            countryDTO.coatOfArms?.png,
            countryDTO.flags.png
        )
    }
}

//fun fromCountryDTOListToCountryDomainList(countryDTO: List<CountryDTO>){
//    return
//     countryDTO.map { fromCountryDTOListToCountryDomainList(it) }
//}