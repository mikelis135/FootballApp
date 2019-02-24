package com.football.taiwo.football.Home

import android.util.Log

class ApiUtils {

    companion object {

        private var BASE_URL: String = "https://api.football-data.org/v2/"

        val soService: HomeService
            get() {
                Log.e("h", "h")
                return RetrofitClient.getClient(BASE_URL).create(HomeService::class.java)
            }
    }

}
