package com.example.kotlinappfirst.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(cart: Cart)

    @Query("SELECT * from cart_table")
    fun getCart(): LiveData<List<Cart>>
}