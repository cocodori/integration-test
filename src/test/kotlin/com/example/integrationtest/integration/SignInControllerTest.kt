package com.example.integrationtest.integration

import com.example.integrationtest.integration.SignInService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@ExtendWith(MockKExtension::class)
@WebMvcTest(controllers = [SignInController::class])
internal class SignInControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockkBean
    private lateinit var signInService: SignInService

    @Test
    fun signInRequest() {
        //given
        val idJson = 1

        every { signInService.signIn(any()) } returns User.TEMP

        //when
        val response = mockMvc.post("/sign-in") {
            contentType = MediaType.APPLICATION_JSON
            content = idJson
        }


        response.andExpect {
            status { isOk() }
            jsonPath("$['id']") { value(1) }
        }.andDo { print() }
    }
}