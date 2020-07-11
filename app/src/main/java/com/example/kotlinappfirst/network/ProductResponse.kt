package com.example.kotlinappfirst.network

import com.example.kotlinappfirst.database.Product
import com.google.gson.annotations.SerializedName

data class ProductResponse (
    @SerializedName("products")
    var products: ArrayList<Product>
    )