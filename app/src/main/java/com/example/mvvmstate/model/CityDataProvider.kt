package com.example.mvvmstate.model

import com.example.mvvmstate.R

class CityDataProvider {

    private val cities = arrayListOf<City>()

    init {
        cities.add(City("Chennai", R.drawable.chennai,12000000))
        cities.add(City("Mumbai", R.drawable.mumbai,13000000))
        cities.add(City("Hyderabad", R.drawable.hyderabad,6000000))
        cities.add(City("Kolkata", R.drawable.kolkata,15000000))
        cities.add(City("Bengaluru", R.drawable.bengaluru,8000000))
        cities.add(City("Vizhag", R.drawable.vizhag,2000000))
        cities.add(City("Jaipur", R.drawable.jaipur,3000000))
        cities.add(City("Pune", R.drawable.pune,4000000))
        cities.add(City("Lucknow", R.drawable.lucknow,5000000))

    }

    fun getCities() = cities




}