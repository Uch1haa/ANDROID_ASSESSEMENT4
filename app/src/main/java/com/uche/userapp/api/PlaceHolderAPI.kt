package com.uche.userapp.api

import com.uche.userapp.model.Item
import com.uche.userapp.model.Student
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface PlaceHolderAPI {
    @GET("items")
    suspend fun getItem(): List<Item>

    @POST("students")
    suspend fun addStudents(@Body newStudent: Student): List<Student>

}