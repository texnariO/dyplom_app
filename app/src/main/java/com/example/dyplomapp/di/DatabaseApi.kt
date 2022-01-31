package com.example.dyplomapp.di

import com.example.dyplomapp.di.models.SimpleRequest
import com.example.dyplomapp.util.Constants.INVITE_CODE_REQUEST
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface DatabaseApi {

    @POST(INVITE_CODE_REQUEST)
    suspend fun checkInviteCode(@Body inviteCode: String): Response<SimpleRequest>

    companion object{
        const val BASE_URL = "http://192.168.8.107:8080"
    }
}