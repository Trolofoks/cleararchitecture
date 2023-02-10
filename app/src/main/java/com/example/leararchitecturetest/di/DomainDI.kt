package com.example.leararchitecturetest.di

import com.example.leararchitecturetest.domain.usecase.GetUserNameUseCase
import com.example.leararchitecturetest.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module


val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

}