package com.jschoi.clone.weatherapp.Network

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * 서버에서 호출할 메서드를 선언하는 인터페이스
 *
 */
interface RetrofitService {


    @FormUrlEncoded
    @POST("Supplement/List")
    fun requestList(
        @Field("s_name") s_name: String
    ): Call<ArrayList<String>>

}