package com.uche.userapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object UserProvider {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://ict-yep-backend.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val placeHolderAPI = retrofit.create(PlaceHolderAPI::class.java)
}