package com.example.davaleba7.restapi

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
object Retrofit {
    private lateinit var retrofit: Retrofit
    private lateinit var okHttpClient: OkHttpClient

    fun initClient() {

        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl("http://www.mocky.io/v2/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    private fun <S> getService(serviceClass: Class<S>) : S {
        return retrofit.create(serviceClass)
    }


    val mockApi: ApiService
        get() = getService(ApiService::class.java)
}