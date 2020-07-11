package com.example.kotlinappfirst.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("/test.json")
    fun getCurrentProductsData(): Call<ProductResponse>
}