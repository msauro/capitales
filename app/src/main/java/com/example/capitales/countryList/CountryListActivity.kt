package com.example.capitales.countryList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capitales.Country
import com.example.capitales.R
import com.example.capitales.databinding.ActivityCountryListBinding

class CountryListActivity : AppCompatActivity() {

    private val countryListViewModel: CountryListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCountryListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler = binding.countryRecycler
        recycler.layoutManager = LinearLayoutManager(this)

        val adapter = CountryAdapter()
        recycler.adapter = adapter

        countryListViewModel.countryList.observe(this){
            countryList->
            adapter.submitList(countryList)
        }
    }

}