package com.example.leararchitecturetest.di

import com.example.leararchitecturetest.domain.repository.UserRepository
import com.example.leararchitecturetest.domain.usecase.GetUserNameUseCase
import com.example.leararchitecturetest.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository) : SaveUserNameUseCase{
        return SaveUserNameUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase{
        return GetUserNameUseCase(userRepository = userRepository)
    }

}