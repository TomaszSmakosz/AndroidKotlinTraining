package com.example.kotlinappfirst.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private val client = OkHttpClient.Builder().build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://ng-diet-planner.firebaseio.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }

//    val getClient: ProductService
//        get() {
//
//            val gson = GsonBuilder()
//                .setLenient()
//                .create()
//            val interceptor = HttpLoggingInterceptor()
//            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
//
//            val retrofit = Retrofit.Builder()
//                .baseUrl("https://ng-diet-planner.firebaseio.com")
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build()
//
//            return retrofit.create(ProductService::class.java)
//
//        }


//    val request = ServiceBuilder.buildService(TmdbEndpoints::class.java)
//    val call = request.getMovies(getString(R.string.api_key))
//
//    call.enqueue(object : Callback<PopularMovies>{
//        override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
//            if (response.isSuccessful){
//                progress_bar.visibility = View.GONE
//                recyclerView.apply {
//                    setHasFixedSize(true)
//                    layoutManager = LinearLayoutManager(this@MainActivity)
//                    adapter = MoviesAdapter(response.body()!!.results)
//                }
//            }
//        }
//        override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
//            Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
//        }
//    })
}