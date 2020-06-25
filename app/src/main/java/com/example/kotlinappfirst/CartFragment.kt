package com.example.kotlinappfirst

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinappfirst.adapters.CartProductAdapter
import com.example.kotlinappfirst.adapters.ShopProductAdapter
import com.example.kotlinappfirst.databinding.CartFragmentBinding
import com.example.kotlinappfirst.databinding.CartFragmentBindingImpl
import kotlinx.android.synthetic.main.cart_fragment.*
import kotlinx.android.synthetic.main.shop_fragment.*
import kotlinx.android.synthetic.main.shop_fragment.recyclerview


class CartFragment : Fragment() {

    companion object {
        fun newInstance() = CartFragment()
    }

    private lateinit var viewModel: CartViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        //val products = viewModel.allProducts//AppDatabase.getDatabase(context!!).ProductDao().getProducts()

        val binding: CartFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.cart_fragment, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        return binding.root//inflater.inflate(R.layout.cart_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CartProductAdapter(viewModel)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.addItemDecoration(
            DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL)
        )
        viewModel.allCartProducts.observe(viewLifecycleOwner, Observer { productList ->
            productList?.let {
                adapter.setItems(it)
            }
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
