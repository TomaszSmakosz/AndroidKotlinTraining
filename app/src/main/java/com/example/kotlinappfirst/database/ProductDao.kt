package com.example.kotlinappfirst.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product)

    @Update
    suspend fun update(product: Product)

    @Query("SELECT * from product_table")
    fun getProduct(): LiveData<List<Product>>

    @Query("SELECT * from product_table")
    fun getProducts(): List<Product>

    @Query("SELECT * from product_table where externalId = :ext")
    fun getProductByExternalId(ext: String?): List<Product>

    @Query("SELECT * from product_table where in_cart_amount > 0")
    fun getCartProducts(): LiveData<List<Product>>

    suspend fun insertOrUpdate(product: Product){
        val items = getProductByExternalId(product.externalId)
        if(items.isEmpty()){
            insert(product)
        }
        else{
            product.id = items[0].id
            update(product)
        }
    }
}