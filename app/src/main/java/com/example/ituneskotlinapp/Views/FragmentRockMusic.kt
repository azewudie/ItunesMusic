package com.example.ituneskotlinapp.Views
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ituneskotlinapp.Models.MusicData
import com.example.ituneskotlinapp.Models.rockMusic
import com.example.ituneskotlinapp.ViewModels.MusicViewModel
import com.example.ituneskotlinapp.Views.adapter.MusicAdapter
import com.example.ituneskotlinapp.databinding.FragmentRockMusicBinding
class FragmentRockMusic : Fragment() {
    private lateinit var binding:FragmentRockMusicBinding
    private lateinit var adapter: MusicAdapter
   private val viewModel:MusicViewModel by lazy {
       ViewModelProvider(
           this
       )[MusicViewModel::class.java]
   }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentRockMusicBinding.inflate(
            inflater,
            container,
            false
        )
        initObservables()
        initViews()
        Log.d("binding", "onCreateView: ${binding.root}")
        return binding.root
    }

    private fun initViews() {
        adapter = MusicAdapter(emptyList()){
            updateAdapter(it as List<MusicData>)
        }
        Log.d("test", "initViews: $adapter")
        binding.rvRockMusic.adapter =adapter
        binding.rvRockMusic.layoutManager =LinearLayoutManager(context)
    }

    private fun initObservables() {
        viewModel?.musicRock()
        viewModel.rockMusicResult.observe(viewLifecycleOwner, Observer {
            updateAdapter(it)
        })

    }

    open fun updateAdapter(dataSet: List<MusicData>){
        adapter.updateList(dataSet)
    }
}