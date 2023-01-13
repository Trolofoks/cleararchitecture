package com.example.leararchitecturetest.data.repository

import com.example.leararchitecturetest.data.storage.model.UserModel
import com.example.leararchitecturetest.data.storage.UserStorage
import com.example.leararchitecturetest.domain.models.SaveUserNameParamModel
import com.example.leararchitecturetest.domain.models.UserNameModel
import com.example.leararchitecturetest.domain.repository.UserRepository

//добавляем зависимость от UserStorage
class UserRepositoryImplementation(private var userStorage: UserStorage) : UserRepository{

    override fun saveName(saveParam: SaveUserNameParamModel):Boolean{
        //превращаем model из domain в model из data и никакой логики
        val user = UserModel(firstName = saveParam.name, lastName = "")
        val result = userStorage.save(user)
        return result
    }
    override fun getName():UserNameModel{
        val user = userStorage.get()
        return UserNameModel(user.firstName, user.lastName)
    }

}