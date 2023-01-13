package com.example.leararchitecturetest.domain.repository

import com.example.leararchitecturetest.domain.models.SaveUserNameParamModel
import com.example.leararchitecturetest.domain.models.UserNameModel
//Это интерфейс, он просто связывает но сам не имеет логики
interface UserRepository {

    fun saveName(saveParam: SaveUserNameParamModel): Boolean

    fun getName(): UserNameModel
}