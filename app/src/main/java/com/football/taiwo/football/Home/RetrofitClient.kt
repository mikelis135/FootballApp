package com.football.taiwo.football.Home

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    // static method getClient

    companion object {
        fun getClient(baseUrl: String): Retrofit {
             var retrofit: Retrofit? = null
            if (retrofit == null) {

                // interceptor to log the data from the retrofit client
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                val client = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()

                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()

            }
            return retrofit!!

        }
    }
}

