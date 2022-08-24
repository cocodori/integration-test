package com.example.integrationtest.integration

import com.example.integrationtest.integration.SignInService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SignInController(
    private val signInService: SignInService
) {
    @PostMapping("/sign-in")
    fun signIn(
        @RequestBody id: Long
    ): User {
        val user = signInService.signIn(userId = id)

        return user
    }
}