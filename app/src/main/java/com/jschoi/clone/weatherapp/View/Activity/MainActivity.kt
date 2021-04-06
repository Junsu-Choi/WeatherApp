package com.jschoi.clone.weatherapp.View.Activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jschoi.clone.weatherapp.Network.RetrofitClient
import com.jschoi.clone.weatherapp.Network.RetrofitService
import com.jschoi.clone.weatherapp.R
import com.jschoi.clone.weatherapp.Res.ResSample
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG = javaClass.simpleName

    private lateinit var retrofit: Retrofit
    private lateinit var supplementService: RetrofitService

    private val tvTemperature: TextView by lazy {
        findViewById(R.id.tv_temperature)
    }
    private val edCity: EditText by lazy {
        findViewById(R.id.ed_city)
    }
    private val btnSearch: ImageButton by lazy {
        findViewById(R.id.btn_search)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit = RetrofitClient.getInstance()
        supplementService = retrofit.create(RetrofitService::class.java)

        btnSearch.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.d(TAG, "OnClick...")
        when (v!!.id) {
            btnSearch.id -> if (edCity.toString().isNullOrEmpty()) {
                return
            } else {
                initRetrofit(edCity.text.toString())
            }
        }
    }

    private fun initRetrofit(searchData: String) {
        supplementService.reqeustSample(searchData, getString(R.string.weather_app_key))
            .enqueue(object : Callback<ResSample> {
                override fun onResponse(call: Call<ResSample>, response: Response<ResSample>) {
                    val res = response.body()
                    if (res != null) {
                        // 온도
                        tvTemperature.text = String.format("%d°C", (res.main.temp - 273.15).toInt())
                    } else {
                        showToast(false, null)
                    }
                }

                override fun onFailure(call: Call<ResSample>, t: Throwable) {
                    Log.d(TAG, ">>>>>>>>>>>>>>>>>>>>> ${t}")
                }
            })
    }


    /**
     * Show Toast Message
     */
    private fun showToast(isLongDuration: Boolean, message: String?) {
        var duration = Toast.LENGTH_SHORT

        if (message.isNullOrEmpty()) {
            message.apply {
                getString(R.string.error_network)
            }
        }
        if (isLongDuration) {
            duration = Toast.LENGTH_LONG
        }
        Toast.makeText(this@MainActivity, message, duration).show()
    }
}
