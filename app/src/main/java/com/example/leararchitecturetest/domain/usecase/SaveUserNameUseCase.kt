package com.example.leararchitecturetest.domain.usecase

import com.example.leararchitecturetest.domain.models.SaveUserNameParamModel
import com.example.leararchitecturetest.domain.repository.UserRepository

//сюда идет ИМЕННО Interface т.к. domain не может не от чего наследоватся
class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParamModel): Boolean{

        val oldUserName = userRepository.getName()
        if (oldUserName.firstName == param.name) return true


        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}