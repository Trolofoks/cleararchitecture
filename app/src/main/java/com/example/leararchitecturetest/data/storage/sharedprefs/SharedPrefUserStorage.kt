package com.example.leararchitecturetest.data.storage.sharedprefs

import android.content.Context
import com.example.leararchitecturetest.data.storage.UserStorage
import com.example.leararchitecturetest.data.storage.model.UserModel

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_LAST_NAME = "last_name"
private const val DEFAULT_NAME = "default"

class SharedPrefUserStorage(context: Context): UserStorage {

    val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(userModel: UserModel): Boolean {
        //ТУТ НИКАКОЙ ЛОГИКИ только сохранил
        sharedPreferences.edit().putString(KEY_FIRST_NAME, userModel.firstName).apply()
            sharedPreferences.edit().putString(KEY_LAST_NAME, userModel.lastName).apply()
        return true
    }

    override fun get(): UserModel {
        //ТОЛЬКО ПОЛУЧАЕМ
        //получаем значения, чтобы не было String? добавляем (?: "")
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        return UserModel(firstName = firstName, lastName = lastName)
    }

}