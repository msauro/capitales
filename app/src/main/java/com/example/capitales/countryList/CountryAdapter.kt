package com.example.capitales.countryList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.capitales.Country
import com.example.capitales.databinding.ActivityCountryListBinding
import com.example.capitales.databinding.CountryListItemBinding

class CountryAdapter: ListAdapter<Country, CountryAdapter.CountryViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Country>(){
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean{
            return oldItem === newItem
        }
        override fun areContentsTheSame (oldItem: Country, newItem: Country): Boolean{
            return oldItem.flag == newItem.flag
        }
    }

    private var onItemClickListener: ((Country) -> Unit)? = null
    fun setOnItemClickListener(onItemClickListener: (Country)-> Unit){
        this.onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = CountryListItemBinding.inflate(LayoutInflater.from(parent.context))
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(countryViewHolder: CountryViewHolder, position: Int) {
        val country = getItem(position)
        countryViewHolder.bind(country)
    }

    inner class CountryViewHolder(private val binding: CountryListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(country: Country){
            binding.countryFlag.text = country.name.common
            binding.countryFlag.setOnClickListener{
            onItemClickListener?.invoke(country)
            }
        }
    }
}