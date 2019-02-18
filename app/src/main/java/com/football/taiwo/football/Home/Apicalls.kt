package com.football.taiwo.football.Home

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Apicalls {

   companion object {
        fun create(): HomeService {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create())
                .addConverterFactory( GsonConverterFactory.create() )
                .baseUrl("https://api.football-data.org/")
                .client(client)
                .build()

            return retrofit.create(HomeService::class.java)
        }
    }
}