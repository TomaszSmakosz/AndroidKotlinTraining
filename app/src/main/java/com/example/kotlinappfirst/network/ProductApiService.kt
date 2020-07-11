package com.example.kotlinappfirst.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://ng-diet-planner.firebaseio.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ProductApiService {
    @GET("/test.json")
    fun getCurrentProductsData(): Call<ProductResponse>
}

object ProductApi {
    val RETROFIT_SERVICE: ProductApiService by lazy {
        retrofit.create(ProductApiService::class.java)
    }
}