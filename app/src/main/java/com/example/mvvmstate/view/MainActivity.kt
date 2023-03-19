package com.example.mvvmstate.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmstate.R
import com.example.mvvmstate.databinding.ActivityMainBinding
import com.example.mvvmstate.viewmodel.CityViewModel

class MainActivity : AppCompatActivity() {

   // private val viewmodel: CityViewModel by viewModels()

    private lateinit var viewModel: CityViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(CityViewModel::class.java)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getCityData().observe(this, {city ->
            binding.cityimage.setImageDrawable(
                ResourcesCompat.getDrawable(resources, city.img, applicationContext.theme)
            )
            binding.cityNameTV.text = city.name
            binding.cityPopulation.text = city.population.toString()


        })
    }

}