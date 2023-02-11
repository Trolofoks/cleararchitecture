package com.example.leararchitecturetest.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.leararchitecturetest.domain.models.SaveUserNameParamModel
import com.example.leararchitecturetest.domain.models.UserNameModel
import com.example.leararchitecturetest.domain.usecase.GetUserNameUseCase
import com.example.leararchitecturetest.domain.usecase.SaveUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//передаем сюда все нужное
@HiltViewModel
class MainViewModel @Inject constructor(
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase
) : ViewModel() {

    //ее можно обсерверить, тоесть обнавлять значения когда она меняется
    private var resultLiveMutable = MutableLiveData<String>()
    //защита от изменений в activity
    val resultLive : LiveData<String> = resultLiveMutable

    override fun onCleared() {
        super.onCleared()
        Log.d("MyLog","VM cleared")
    }
    init { Log.d("MyLog","VM created") }

    //функции ничего не возвращают, они только сохраняют
    fun save(text: String){
        val params = SaveUserNameParamModel(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
        resultLiveMutable.value =  "send Result = $resultData"
    }

    fun get() {
        //Use case выполняет заданную задачу и возвращает результат
        val userName: UserNameModel = getUserNameUseCase.execute()
        resultLiveMutable.value = userName.firstName + userName.lastName
    }
}