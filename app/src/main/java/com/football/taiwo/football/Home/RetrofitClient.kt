package com.football.taiwo.football.Home

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class RetrofitClient {


    companion object {
        public fun getClient(baseUrl: String): Retrofit {
             var retrofit: Retrofit? = null
            if (retrofit == null) {

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

