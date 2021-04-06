package com.jschoi.clone.weatherapp.View.Activity

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jschoi.clone.weatherapp.Network.RetrofitClient
import com.jschoi.clone.weatherapp.Network.RetrofitService
import com.jschoi.clone.weatherapp.R
import com.jschoi.clone.weatherapp.Res.ResSample
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName

    private lateinit var retrofit: Retrofit
    private lateinit var supplementService: RetrofitService

    private lateinit var tvTemperature: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTemperature = findViewById(R.id.tv_temperature);

        initRetrofit()
    }


    private fun initRetrofit() {
        retrofit = RetrofitClient.getInstance()
        supplementService = retrofit.create(RetrofitService::class.java)

        supplementService.reqeustSample("seoul", getString(R.string.weather_app_key))
            .enqueue(object : Callback<ResSample> {
                override fun onResponse(call: Call<ResSample>, response: Response<ResSample>) {
                    val res = response.body()!!
                    // 온도
                    tvTemperature.text = String.format("%d°C", (res.main.temp - 273.15).toInt())
                }

                override fun onFailure(call: Call<ResSample>, t: Throwable) {
                    Log.d(TAG, ">>>>>>>>>>>>>>>>>>>>> ${t}")
                }
            })
    }
}