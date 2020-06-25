package com.example.kotlinappfirst.repository

import androidx.lifecycle.LiveData
import com.example.kotlinappfirst.database.Cart
import com.example.kotlinappfirst.database.CartDao
import com.example.kotlinappfirst.database.Product
import com.example.kotlinappfirst.database.ProductDao

class CartRepository(private val cartDao: CartDao) {

    val allCartProducts: LiveData<List<Cart>> = cartDao.getCart()

    suspend fun insert(cart: Cart) {
        cartDao.insert(cart)
    }
}