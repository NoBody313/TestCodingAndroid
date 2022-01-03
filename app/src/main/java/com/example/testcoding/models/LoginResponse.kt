package com.example.testcoding.models

data class LoginResponse (
    val error: Boolean,
    val message: String,
    val user: User,

    val username: String,
    val password: String
)