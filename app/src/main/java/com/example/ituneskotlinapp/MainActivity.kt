package com.example.ituneskotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.ituneskotlinapp.Views.FragmentClassicMusic
import com.example.ituneskotlinapp.Views.FragmentPopMusic
import com.example.ituneskotlinapp.databinding.ActivityMainBinding
import com.example.ituneskotlinapp.Views.FragmentRockMusic

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )


        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container,FragmentRockMusic())
            .commit()

        binding.refreshLayout.setOnRefreshListener {
            onRefresh()
        }
        binding.Home.setOnClickListener{
            homeColor()
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container,FragmentRockMusic())
                .addToBackStack(binding.PopMusic.toString())
                .commit()
        }
        binding.classicMusic.setOnClickListener {
            classicColor()
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container,FragmentClassicMusic())
                .addToBackStack(null)
                .commit()
        }
        binding.PopMusic.setOnClickListener {
            popColor()
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container,FragmentPopMusic())
                .addToBackStack(null)
                .commit()
        }

    }

    private fun popColor() {
        binding.tvClassic.setTextColor(resources.getColor(R.color.black))
        binding.pop.setTextColor(resources.getColor(R.color.dark_blue))
        binding.popNotification.setImageResource(R.drawable.ic_blue_notifications_24)
        binding.queueMusic.setImageResource(R.drawable.ic_baseline_queue_music_24)
        binding.ivHome.setImageResource(R.drawable.ic_black_home_24)
        binding.homeRock.setTextColor(resources.getColor(R.color.black))
    }

    private fun classicColor() {
        binding.tvClassic.setTextColor(resources.getColor(R.color.dark_blue))
        binding.queueMusic.setImageResource(R.drawable.ic_blue_queue_music_24)
        binding.pop.setTextColor(resources.getColor(R.color.black))
        binding.homeRock.setTextColor(resources.getColor(R.color.black))
        binding.ivHome.setImageResource(R.drawable.ic_black_home_24)
        binding.popNotification.setImageResource(R.drawable.ic_baseline_notifications_24)
    }

    private fun homeColor() {
        binding.homeRock.setTextColor(resources.getColor(R.color.dark_blue))
        binding.popNotification.setImageResource(R.drawable.ic_baseline_notifications_24)
        binding.queueMusic.setImageResource(R.drawable.ic_baseline_queue_music_24)
        binding.tvClassic.setTextColor(resources.getColor(R.color.black))
        binding.pop.setTextColor(resources.getColor(R.color.black))
        binding.ivHome.setImageResource(R.drawable.ic_baseline_home_24)
    }
    fun onRefresh(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container,FragmentRockMusic())
            .commit()
        binding.refreshLayout.setRefreshing(false)
    }

}