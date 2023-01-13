package com.example.leararchitecturetest.domain.usecase

import com.example.leararchitecturetest.domain.models.UserNameModel
import com.example.leararchitecturetest.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserNameModel {
        return userRepository.getName()
    }
}