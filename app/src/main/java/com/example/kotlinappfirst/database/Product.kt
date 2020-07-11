package com.example.kotlinappfirst.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "product_table", foreignKeys = [])
class Product(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "externalId")
    @SerializedName("externalId")
    val externalId: String?,
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,
    @ColumnInfo(name = "price")
    @SerializedName("price")
    val price: Float,
    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String,
    @ColumnInfo(name = "in_cart_amount")
    @SerializedName("in_cart_amount")
    var inCartAmount: Int
)