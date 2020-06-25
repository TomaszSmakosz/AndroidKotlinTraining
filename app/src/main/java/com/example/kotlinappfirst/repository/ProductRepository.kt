package com.example.kotlinappfirst.repository

import androidx.lifecycle.LiveData
import com.example.kotlinappfirst.database.Product
import com.example.kotlinappfirst.database.ProductDao

class ProductRepository(private val productDao: ProductDao) {

    val allProducts: LiveData<List<Product>> = productDao.getProduct()
    val allCartProducts: LiveData<List<Product>> = productDao.getCartProducts()

    suspend fun insert(product: Product) {
        productDao.insert(product)
    }
}