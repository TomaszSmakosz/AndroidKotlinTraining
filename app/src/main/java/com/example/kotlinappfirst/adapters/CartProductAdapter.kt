package com.example.kotlinappfirst.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinappfirst.CartViewModel
import com.example.kotlinappfirst.R
import com.example.kotlinappfirst.ShopViewModel
import com.example.kotlinappfirst.database.Product
import kotlinx.android.synthetic.main.cart_product_item.view.*
import kotlinx.android.synthetic.main.shop_product_item.view.*
import kotlinx.android.synthetic.main.shop_product_item.view.ib_product_add
import kotlinx.android.synthetic.main.shop_product_item.view.ib_product_remove
import kotlinx.android.synthetic.main.shop_product_item.view.iv_product
import kotlinx.android.synthetic.main.shop_product_item.view.tv_product_amount
import kotlinx.android.synthetic.main.shop_product_item.view.tv_product_name

class CartProductAdapter(private val cartViewModel: CartViewModel) : RecyclerView.Adapter<CartProductAdapter.ProductViewHolder>() {

    private var productList: List<Product> = emptyList<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cart_product_item,
            parent, false)
        return ProductViewHolder(
            itemView
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.tvProductName.text = currentItem.name
        holder.tvProductAmount.apply {
            text = currentItem.inCartAmount.toString()
        }
        holder.tvProductPrice.apply {
            text = (currentItem.inCartAmount * currentItem.price).toString()
        }

        holder.ibProductAdd.setOnClickListener(){
            currentItem.inCartAmount += 1
            cartViewModel.insert(currentItem)
        }
        holder.ibProductRemove.setOnClickListener(){
            if (currentItem.inCartAmount > 0){
                currentItem.inCartAmount -=1
                cartViewModel.insert(currentItem)
            }
        }
    }

    override fun getItemCount() = productList.size

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProduct: ImageView = itemView.iv_product
        val tvProductName: TextView = itemView.tv_product_name
        val tvProductAmount: TextView = itemView.tv_product_amount
        val tvProductPrice: TextView = itemView.tv_product_price
        val ibProductAdd: ImageButton = itemView.ib_product_add
        val ibProductRemove: ImageButton = itemView.ib_product_remove
    }

    internal fun setItems(productList: List<Product>) {
        this.productList = productList
        cartViewModel.calculateTotalPrice()
        notifyDataSetChanged()
    }

}