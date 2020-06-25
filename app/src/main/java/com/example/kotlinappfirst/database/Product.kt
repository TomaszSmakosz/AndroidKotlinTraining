package com.example.kotlinappfirst.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table", foreignKeys = [])
class Product(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: Float,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "in_cart_amount") var inCartAmount: Int
)