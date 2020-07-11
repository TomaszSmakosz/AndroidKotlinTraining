package com.example.kotlinappfirst.database

import androidx.room.*

//@Entity(tableName = "cart_table", foreignKeys = [ForeignKey(entity = Product::class,
//                                    parentColumns = arrayOf("id"),
//                                    childColumns = arrayOf("product_id"),
//                                    onDelete = ForeignKey.CASCADE)])
@Entity(tableName = "cart_table")
class Cart(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "product_id") val productId: Int?,
    @ColumnInfo(name = "amount") val amount: Int
    //@Embedded(prefix = "cart_") val product: Product
)