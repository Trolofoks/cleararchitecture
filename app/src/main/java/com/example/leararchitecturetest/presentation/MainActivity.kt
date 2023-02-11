package com.example.leararchitecturetest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.leararchitecturetest.databinding.ActivityMainBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Обсерверим
        vm.resultLive.observe(this, Observer{
            binding.textView.text = it
        })

        binding.buttonGetData.setOnClickListener{
            //только вызвыаем функцию и ничего не получаем
            vm.get()
        }
        binding.buttonSaveData.setOnClickListener{
            val text = binding.editTextTextPersonName.text.toString()
            vm.save(text)
        }
    }
}