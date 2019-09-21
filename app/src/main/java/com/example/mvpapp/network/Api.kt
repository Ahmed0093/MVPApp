package com.example.mvpapp.network

import com.example.mvpapp.model.ApiResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Ahmed Abdullah on 9/20/2019.
 */
interface Api {
    @GET("v2/viewed/7.json?api-key=KLJbXpC8XcOCl1KHJ31jT1OXTfUDY4Wj")
    fun getArticles(): Observable<ApiResponse>
    @GET("/")
    fun getArticles2(): Call<ApiResponse>
}