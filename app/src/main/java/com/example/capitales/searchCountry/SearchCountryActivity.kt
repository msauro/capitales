package com.example.capitales.searchCountry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.capitales.R
import com.example.capitales.databinding.ActivitySearchCountryBinding

class SearchCountryActivity : AppCompatActivity() {

    lateinit var inputCountryName : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySearchCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchCountryButton.setOnClickListener{
            inputCountryName = findViewById(R.id.input_search)
            val countryName = inputCountryName.text.toString()

            search(countryName)
        }
    }

    private fun search(countryName: String) {
        Toast.makeText(this, countryName, Toast.LENGTH_LONG).show()

        //Country.search(countryName)//TOMA EL VALOR DEL INPUT Y HACE UN REQUEST al aAPI
    }
}