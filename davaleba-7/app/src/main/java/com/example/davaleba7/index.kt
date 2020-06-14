package com.example.davaleba7

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.example.davaleba7.restapi.Retrofit

class index: Application() {

    override fun onCreate() {
        super.onCreate()
        Retrofit.initClient()
    }
}