package com.example.ituneskotlinapp.Models.Observer


import com.example.ituneskotlinapp.Models.classicMusic
import com.example.ituneskotlinapp.Models.popMusic
import com.example.ituneskotlinapp.Models.rockMusic
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 1-Retrofit dependencies
 * 2-Create Retrofit Interface (Service)
 * 3-In the service Create the HTTP  verbs
 * 4- Create the Retrofit object.(Singleton)
 * BASE_URL------>https://itunes.apple.com/
 *GET----------->search?
 * query----------> term=rock&ampmedia=music&amp;entity=song&amp;limit=50
 * https://itunes.apple.com/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50
 *https://itunes.apple.com/search?term=pop&amp;media=music&amp;entity=song&amp;limit=50
 *  * query----------> term=rock&amp;
 * media=music&amp;
 * entity=song&amp;
 * limit=50
 *BASE_URL /GET? /Query / query
 */
interface  Service{
    @GET(ROCK_GET)
    fun rockMusicByName(): Call<rockMusic>
    @GET(CLASSIC_GET)
    fun classicMusicByName(): Call<classicMusic>

    @GET(POP_GET)
    fun popMusicByName(): Call<popMusic>

}