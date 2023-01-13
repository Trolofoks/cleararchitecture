package com.example.leararchitecturetest.data.storage

import com.example.leararchitecturetest.data.storage.model.UserModel

//тут мы связываем ЛОГИКУ с сохранением и Repository
interface UserStorage {
    fun save(userModel: UserModel):Boolean
    fun get() : UserModel
}