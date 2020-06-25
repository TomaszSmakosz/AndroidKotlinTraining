package com.example.kotlinappfirst

import android.app.Application
import androidx.lifecycle.*
import com.example.kotlinappfirst.database.AppDatabase
import com.example.kotlinappfirst.database.Product
import com.example.kotlinappfirst.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(application: Application) : AndroidViewModel(application) {
    private val _totalPrice = MutableLiveData<String>()
    private val repository: ProductRepository
    val allCartProducts: LiveData<List<Product>>
    val totalPrice: LiveData<String>
        get() = _totalPrice

    init {
        val productDao = AppDatabase.getDatabase(application).ProductDao()
        repository = ProductRepository(productDao)
        allCartProducts = repository.allCartProducts
    }

    fun insert(product: Product) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(product)
    }

    fun calculateTotalPrice(){
        var total = 0f
        allCartProducts.value?.forEach{
            total += it.price * it.inCartAmount
        }
        //_totalPrice.value = ("%.2f".format(total)).replace(".",",")
        _totalPrice.postValue(("%.2f".format(total)).replace(".",","))
    }


}
