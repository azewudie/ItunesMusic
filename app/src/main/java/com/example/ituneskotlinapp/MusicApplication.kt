package com.example.ituneskotlinapp

import android.content.Context
import android.app.Application

class MusicApplication: Application(){
    /**
     * Initialize Firebase, logger, Analytics
     * Dependency Injection
     *
     */
   override fun onCreate(){
        super.onCreate()
        musicApplication = applicationContext

    }
    companion object{
        lateinit var musicApplication:Context
    }
}