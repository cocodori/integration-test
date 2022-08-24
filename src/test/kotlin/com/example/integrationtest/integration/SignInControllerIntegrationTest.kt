package com.example.integrationtest.integration

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@Import(IntegrationTestConfig::class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
internal class SignInControllerIntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var userRepository: UserRepository

    @Test
    fun signInRequest() {
        //given
        val idJson = 1
        //직접 DB에 저장해야 한다.
        val savedUser = userRepository.save(User(id = 1, name = "hoon"))

        //when
        val response = mockMvc.post("/sign-in") {
            contentType = MediaType.APPLICATION_JSON
            content = idJson
        }

        //then
        response.andExpect {
            status { isOk() }
            jsonPath("$['id']") { value(savedUser.id) }
        }.andDo { print() }
    }
}