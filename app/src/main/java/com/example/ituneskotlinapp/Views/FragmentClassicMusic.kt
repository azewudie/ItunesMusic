package com.example.ituneskotlinapp.Views
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ituneskotlinapp.Models.MusicData
import com.example.ituneskotlinapp.ViewModels.MusicViewModel
import com.example.ituneskotlinapp.Views.adapter.ClassicAdapter
import com.example.ituneskotlinapp.databinding.FragmentClassicMusicBinding

class FragmentClassicMusic : Fragment() {
    private lateinit var binding: FragmentClassicMusicBinding
    private lateinit var adapter: ClassicAdapter
    private val viewModel: MusicViewModel by lazy {
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
        binding = FragmentClassicMusicBinding.inflate(
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
        adapter = ClassicAdapter(emptyList()){
            updateAdapter(it as List<MusicData>)
        }
        Log.d("test", "initViews: $adapter")
        binding.rvClassicMusic.adapter =adapter
        binding.rvClassicMusic.layoutManager = LinearLayoutManager(context)
    }

    private fun initObservables() {
        viewModel?.musicRock()
        viewModel.classicMusicResult.observe(viewLifecycleOwner, Observer {
            updateAdapter(it)
        })

    }

    open fun updateAdapter(dataSet: List<MusicData>){
        adapter.updateList(dataSet)
    }
}