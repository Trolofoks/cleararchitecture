package com.example.leararchitecturetest.di

import com.example.leararchitecturetest.data.repository.UserRepositoryImplementation
import com.example.leararchitecturetest.data.storage.UserStorage
import com.example.leararchitecturetest.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.leararchitecturetest.domain.repository.UserRepository
import org.koin.dsl.module


val dataModule = module {

    single<UserStorage>{
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository>{
        UserRepositoryImplementation(userStorage = get())
    }

}