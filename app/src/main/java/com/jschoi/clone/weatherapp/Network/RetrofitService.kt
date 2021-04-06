package com.jschoi.clone.weatherapp.Network

import com.jschoi.clone.weatherapp.Res.ResSample
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 서버에서 호출할 메서드를 선언하는 인터페이스
 *
 */
interface RetrofitService {

    @GET("http://api.openweathermap.org/data/2.5/weather")
    fun reqeustSample(
        @Query("q") city: String,
        @Query("appid") appid: String
    ): Call<ResSample>

}