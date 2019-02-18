package com.football.taiwo.football

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.room.RoomDatabase
import com.football.taiwo.football.Database.RoomSingleton

class App : Application() {

    companion object {
          lateinit var context : Context

        fun getInstance(context: Context) : RoomSingleton{
            App.context = context
            return RoomSingleton.getInstance(App.context)
        }

    }



}