package com.example.integrationtest.integration

data class User(
    val id: Long? = null,
    val name: String? = "hoon"
) {
    companion object {
        val EMPTY = User(id = -1)

        val TEMP = User(id = 1)
    }
}