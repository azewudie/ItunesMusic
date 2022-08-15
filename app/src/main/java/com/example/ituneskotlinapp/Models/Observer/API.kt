package com.example.ituneskotlinapp.Models.Observer



import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * This is a singleton
 */
object API {
    val musicApi: Service by lazy {
        collectionRetrofit()
    }

    private fun collectionRetrofit(): Service {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Service::class.java)

    }

}

