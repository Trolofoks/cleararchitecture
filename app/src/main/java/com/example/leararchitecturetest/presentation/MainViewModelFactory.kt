package com.example.leararchitecturetest.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.leararchitecturetest.data.repository.UserRepositoryImplementation
import com.example.leararchitecturetest.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.leararchitecturetest.domain.usecase.GetUserNameUseCase
import com.example.leararchitecturetest.domain.usecase.SaveUserNameUseCase

//сюда передаем нужный нам контекст
class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    //тут передаем все UseCase
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImplementation(userStorage = SharedPrefUserStorage(context = context))
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase( userRepository = userRepository )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase( userRepository = userRepository )
    }

    //он обьясняет как строить ViewModel
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //передаем все что нам требуется
        return MainViewModel(saveUserNameUseCase, getUserNameUseCase) as T
    }
}