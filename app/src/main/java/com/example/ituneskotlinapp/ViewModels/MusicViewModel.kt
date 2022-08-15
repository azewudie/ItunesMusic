package com.example.ituneskotlinapp.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ituneskotlinapp.Models.MusicData
import com.example.ituneskotlinapp.Models.Observer.API
import com.example.ituneskotlinapp.Models.classicMusic
import com.example.ituneskotlinapp.Models.popMusic
import com.example.ituneskotlinapp.Models.rockMusic
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MusicViewModel"

class MusicViewModel : ViewModel() {

    /**
     * Rock music
     */
    open var _rockMusicResult = MutableLiveData<List<MusicData>>()

    // Backing Field
   open val rockMusicResult: LiveData<List<MusicData>>
        get() = _rockMusicResult

    /**
     * Rock classic
     */
    private val _classicMusicResult = MutableLiveData<List<MusicData>>()
    val classicMusicResult:LiveData<List<MusicData>>
        get() =_classicMusicResult

    /**
     * Rock pop
     */
    private val _popMusicResult = MutableLiveData<List<MusicData>>()
    val popMusicResult:LiveData<List<MusicData>>
        get() =_popMusicResult

    /**
     * Error message
     */
    private val _errorMessages = MutableLiveData("")

    val errorMessages: LiveData<String>
        get() = _errorMessages

    fun musicRock() {

        Log.d("RockAPI", "musicRock:${API.musicApi} ")

        val call = API.musicApi.rockMusicByName()

        Log.d("CallApI", "musicRock: $call")

        call.enqueue(
            object : Callback<rockMusic> {
                override fun onResponse(call: Call<rockMusic>, response: Response<rockMusic>) {
                    if (response.isSuccessful) {
                        var body = response.body()
                        Log.d("body", "onResponse:${body?.results?.size} ")
                        val resultMusic = body?.results

                        Log.d("BodyMusic", "onResponse:${resultMusic} ")
                        _rockMusicResult.value = resultMusic

                        Log.d("rockMusicResult", "onResponse:${rockMusicResult} ")


                    }else{
                        _errorMessages.value = response.message()
                    }
                }

                override fun onFailure(call: Call<rockMusic>, t: Throwable) {
                    t.printStackTrace()
                    _errorMessages.value = t.message ?: "Unknown error"
                    print(errorMessages)
                }

            }
        )


        /**
         * Classic
         */



        val classicCall = API.musicApi.classicMusicByName()
        Log.d("CallApI", "musicRock: $classicCall")
        classicCall.enqueue(
            object : Callback<classicMusic> {
                override fun onResponse(call: Call<classicMusic>, response: Response<classicMusic>) {
                    if (response.isSuccessful) {
                        var body = response.body()
                        Log.d("bodyClassic", "onResponse:${body?.results?.size} ")
                        val resultMusic = body?.results
                        Log.d("BodyMusic", "onResponse:${resultMusic} ")
                        _classicMusicResult.value = resultMusic

                        Log.d("rockMusicResult", "onResponse:${classicMusicResult} ")


                    }else{
                        _errorMessages.value = response.message()
                    }
                }

                override fun onFailure(call: Call<classicMusic>, t: Throwable) {
                    t.printStackTrace()
                    _errorMessages.value = t.message ?: "Unknown error"
                    print(errorMessages)
                }

            }
        )

        /****
         * POP
         */

        val callPop = API.musicApi.popMusicByName()
        Log.d("CallApI", "musicRock: $callPop")
        callPop.enqueue(
            object : Callback<popMusic> {
                override fun onResponse(call: Call<popMusic>, response: Response<popMusic>) {
                    if (response.isSuccessful) {
                        var body = response.body()
                        Log.d("bodyPop", "onResponse:${body?.results?.size} ")
                        val resultMusic = body?.results
                        Log.d("BodyMusic", "onResponse:${resultMusic} ")
                        _popMusicResult.value = resultMusic

                        Log.d("rockMusicResult", "onResponse:${popMusicResult} ")


                    }else{
                        _errorMessages.value = response.message()
                    }
                }

                override fun onFailure(call: Call<popMusic>, t: Throwable) {
                    t.printStackTrace()
                    _errorMessages.value = t.message ?: "Unknown error"
                    print(errorMessages)
                }

            }
        )
    }
}