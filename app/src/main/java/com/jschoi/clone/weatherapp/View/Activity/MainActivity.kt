package com.jschoi.clone.weatherapp.View.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jschoi.clone.weatherapp.Network.RetrofitClient
import com.jschoi.clone.weatherapp.Network.RetrofitService
import com.jschoi.clone.weatherapp.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var retrofit: Retrofit
    private lateinit var supplementService: RetrofitService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun initRetrofit() {
        retrofit = RetrofitClient.getInstance()
        supplementService = retrofit.create(RetrofitService::class.java)

        supplementService.requestList("a").enqueue(object :Callback<ArrayList<String>>{
            override fun onResponse(call: Call<ArrayList<String>>, response: Response<ArrayList<String>>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}