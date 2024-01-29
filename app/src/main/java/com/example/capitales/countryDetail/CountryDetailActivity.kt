package com.example.capitales.countryDetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import coil.load
import com.example.capitales.Country
import com.example.capitales.R
import com.example.capitales.countryList.CountryAdapter
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
        val adapter = CountryAdapter()
        adapter.setOnItemClickListener {
            //pasar el country a country detail activity, para esto el obj debe ser parcelable (para pasar un objeto entre activities)
            val intent = Intent(this, CountryDetailActivity::class.java)
            intent.putExtra(COUNTRY_KEY, it)
            startActivity(intent)
        }

        binding.population.text = getString(R.string.population, country.population)
        binding.area.text = getString(R.string.area, country.area)
        binding.country = country
        binding.countryFlag.load(country.flags.png) //con esta libreria COIL, obtengo la imagen
        binding.countryCoat.load(country.coatOfArms.png) // ESTO PARA MOSTRAR EL escudo
        binding.countryBorders.text=(country.borders?.joinToString())
        binding.countryContinents.text=(country.continents?.joinToString())
        binding.closeButton.setOnClickListener {
            finish()
        }
    }
}