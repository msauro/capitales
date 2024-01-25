package com.example.capitales.countryDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.capitales.Country
import com.example.capitales.R
import com.example.capitales.databinding.ActivityCountryDetailBinding

class CountryDetailActivity : AppCompatActivity() {

    companion object{
        const val COUNTRY_KEY = "country"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_country_detail)
        val binding = ActivityCountryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val country = intent?.extras?.getParcelable<Country>(COUNTRY_KEY)
        if (country == null){
            Toast.makeText(this,"Country not found", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        //binding.country MINUTO 8.47 VER VERRRRRRRRRR
        binding.population.text = getString(R.string.population, country.population)
        binding.area.text = getString(R.string.area, country.area) //CON ESTO FALLA
        binding.country = country
    }
}