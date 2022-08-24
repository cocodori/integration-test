package com.example.integrationtest.integration

import org.springframework.stereotype.Service

@Service
class SignInService(
    private val userRepository: UserRepository
) {
    fun signIn(
        userId: Long
    ): User {
        val user = userRepository.findByIdAndActive(userId) ?: User.EMPTY

        return user
    }
}