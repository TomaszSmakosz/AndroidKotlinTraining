package com.example.kotlinappfirst.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product)

    @Query("SELECT * from product_table")
    fun getProduct(): LiveData<List<Product>>

    @Query("SELECT * from product_table")
    fun getProducts(): List<Product>

    @Query("SELECT * from product_table where in_cart_amount > 0")
    fun getCartProducts(): LiveData<List<Product>>
}