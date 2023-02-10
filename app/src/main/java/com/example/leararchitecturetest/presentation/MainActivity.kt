package com.example.leararchitecturetest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.leararchitecturetest.data.repository.UserRepositoryImplementation
import com.example.leararchitecturetest.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.leararchitecturetest.databinding.ActivityMainBinding
import com.example.leararchitecturetest.domain.models.SaveUserNameParamModel
import com.example.leararchitecturetest.domain.models.UserNameModel
import com.example.leararchitecturetest.domain.repository.UserRepository
import com.example.leararchitecturetest.domain.usecase.GetUserNameUseCase
import com.example.leararchitecturetest.domain.usecase.SaveUserNameUseCase
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val vm by viewModel<MainViewModel>()

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