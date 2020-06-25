package com.example.kotlinappfirst

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinappfirst.database.Product
import com.example.kotlinappfirst.adapters.ShopProductAdapter
import kotlinx.android.synthetic.main.shop_fragment.*


class ShopFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = ShopFragment()
    }

    private lateinit var viewModel: ShopViewModel
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shop_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShopViewModel::class.java)
        navController = Navigation.findNavController(view)
        fab_cart.setOnClickListener(this)
        fab_set_db.setOnClickListener(this)
        //val products = viewModel.allProducts//AppDatabase.getDatabase(context!!).ProductDao().getProducts()
        val adapter = ShopProductAdapter(viewModel)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.addItemDecoration(DividerItemDecoration(context,
            DividerItemDecoration.VERTICAL))
        viewModel.allProducts.observe(viewLifecycleOwner, Observer { productList ->
            productList?.let { adapter.setItems(it) }
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            fab_cart.id -> navController!!.navigate(R.id.action_shopFragment_to_cartFragment)
            fab_set_db.id -> viewModel.insert(Product(name = "Klawa", price = 24.00f, description = "nowy sprzet", inCartAmount = 0))
        }
    }
}
