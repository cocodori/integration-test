package com.example.integrationtest.integration

import com.example.integrationtest.integration.SignInService
import com.example.integrationtest.integration.UserRepository
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class SignInServiceTest {

    @MockK
    private lateinit var userRepository: UserRepository
    private lateinit var signInService: SignInService

    @BeforeEach
    fun setUp() {
        signInService = SignInService(userRepository)
    }

@Test
fun signInTest() {
//    every { userRepository.findByIdOrNull(any()) } returns null
    every { userRepository.findByIdAndActive(any()) } returns null

    val actual = signInService.signIn(1)

    assertThat(actual).isEqualTo(User.EMPTY)
}
}