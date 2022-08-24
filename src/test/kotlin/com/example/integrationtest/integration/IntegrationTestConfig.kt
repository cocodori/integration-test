package com.example.integrationtest.integration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.CharacterEncodingFilter

@Configuration
class IntegrationTestConfig {

    /**
     * APPLICATION_JSON_UTF8_VALUE deprecate되면서 응답값 한글 인코딩 깨지는 현상 직접 빈으로 생성해서 해결
     */
    @Bean
    fun characterEncodingFilter(): CharacterEncodingFilter {
        return CharacterEncodingFilter("UTF-8", true)
    }

}