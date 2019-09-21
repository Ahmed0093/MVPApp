package com.example.mvpapp.network

import com.facebook.stetho.okhttp3.BuildConfig

/**
 * Created by Ahmed Abdullah on 9/20/2019.
 */

import com.example.mvpapp.constants.Constants
import com.example.mvpapp.model.ApiResponse
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor
import java.util.*

val networkModule by lazy { NetworkModule() }

class NetworkModule {


    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.API_URL)
            .addConverterFactory(providesGsonConverterFactory())
            .addCallAdapterFactory(providesRxJavaCallAdapterFactory())
            .client(providesOkHttpClient())
            .build()
    }
    fun provideApi(): Api {
        return providesRetrofit().create(Api::class.java);
    }
    fun provideArticleApi(): Observable<ApiResponse> {
        return providesRetrofit().create(Api::class.java).getArticles();
    }


  private fun providesOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        // set your desired log level
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(logging)

            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            client.addNetworkInterceptor(StethoInterceptor())
        }

        return client.build()
    }

    private fun providesGson(): Gson {
        return Gson()
    }


    private fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }


    private fun providesRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }
}