package com.example.integrationtest.integration

import org.springframework.stereotype.Repository

@Repository
class UserRepository {
    fun findByIdOrNull(userId: Long): User? {
        return null
    }

    fun findByIdAndActive(userId: Long): User? {
        return User.TEMP
    }

    fun save(user: User): User {
        println("save $user")
        return user
    }
}

