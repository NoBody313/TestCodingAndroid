package com.example.testcoding.data

import com.example.testcoding.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST

interface Api {

    @POST("login")
    fun userLogin(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>
}