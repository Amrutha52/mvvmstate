package com.example.mvvmstate.viewmodel

import android.app.Application
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.core.os.postDelayed
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmstate.model.City
import com.example.mvvmstate.model.CityDataProvider

class CityViewModel(application: Application) : AndroidViewModel(application) {

    private val cityData = MutableLiveData<City>()
    private val cities = CityDataProvider().getCities()
    private var currentIndex = 0
    private val delay = 2000L

    init {
        loop()
        Log.d("Log", application.toString())
        Log.d("Log", application.filesDir.toString())
    }

    fun getCityData() : LiveData<City> = cityData

    private fun loop()
    {
        Handler(Looper.getMainLooper()).postDelayed({
            updateCities()
        }, delay)
    }

    private fun updateCities()
    {
        currentIndex++
        currentIndex % cities.size

        cityData.value = cities[currentIndex]
        loop()
    }
}

