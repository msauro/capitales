package com.example.capitales.countryList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capitales.api.ApiResponseStatus
import com.example.capitales.countryDetail.CountryDetailActivity
import com.example.capitales.countryDetail.CountryDetailActivity.Companion.COUNTRY_KEY
import com.example.capitales.databinding.ActivityCountryListBinding

class CountryListActivity : AppCompatActivity() {

    private val countryListViewModel: CountryListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCountryListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loadingWheel = binding.loadingWheel

        val recycler = binding.countryRecycler
        recycler.layoutManager = LinearLayoutManager(this)

        val adapter = CountryAdapter()
        adapter.setOnItemClickListener {
            //pasar el country a country detail activity, para esto el obj debe ser parelable (para pasar un objeto entre activities)
            val intent = Intent(this, CountryDetailActivity::class.java)
            intent.putExtra(COUNTRY_KEY, it)
            startActivity(intent)
        }
        recycler.adapter = adapter

        countryListViewModel.countryList.observe(this){
            countryList->
            adapter.submitList(countryList)
        }

        countryListViewModel.status.observe(this){
            status ->
            when(status){
                ApiResponseStatus.LOADING -> {
                    loadingWheel.visibility = View.VISIBLE
                }

                ApiResponseStatus.ERROR -> {
                    loadingWheel.visibility = View.GONE
                    Toast.makeText(this, "Error al descargar los paises", Toast.LENGTH_SHORT).show()
                }
                ApiResponseStatus.SUCCESS -> {
                    loadingWheel.visibility = View.GONE

                }
                else -> {
                    loadingWheel.visibility = View.GONE
                    Toast.makeText(this,"Status desconocido", Toast.LENGTH_SHORT).show()
                }

            }


        }
    }

}