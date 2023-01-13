package com.example.leararchitecturetest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.leararchitecturetest.data.repository.UserRepositoryImplementation
import com.example.leararchitecturetest.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.leararchitecturetest.databinding.ActivityMainBinding
import com.example.leararchitecturetest.domain.models.SaveUserNameParamModel
import com.example.leararchitecturetest.domain.models.UserNameModel
import com.example.leararchitecturetest.domain.repository.UserRepository
import com.example.leararchitecturetest.domain.usecase.GetUserNameUseCase
import com.example.leararchitecturetest.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    //by lazy позволяет загружать их только когда они нужны(т.е. после onCreate) чтобы не надо было инициализировать и создавать отдельно
    //(LazyThreadSafetyMode.NONE) убирает многопоточность чтобы убрать нагрузку
    //всегда стоит передавать applicationContext т.к. с activityContext мне так надежен
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImplementation(userStorage = SharedPrefUserStorage(context = applicationContext))
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase( userRepository = userRepository )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase( userRepository = userRepository )
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGetData.setOnClickListener{
            //Use case выполняет заданную задачу и возвращает результат
            val userName: UserNameModel = getUserNameUseCase.execute()
            binding.textView.text = userName.firstName + userName.lastName
        }
        binding.buttonSaveData.setOnClickListener{
            val text = binding.editTextTextPersonName.text.toString()
            val params = SaveUserNameParamModel(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            binding.textView.text = "send Result = $result"
        }
    }
}