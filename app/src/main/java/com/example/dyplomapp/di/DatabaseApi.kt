package com.example.dyplomapp.di


import com.example.dyplomapp.di.models.SimpleRequest
import com.example.dyplomapp.di.models.UserData
import com.example.dyplomapp.util.Constants.INVITE_CODE_REQUEST
import com.example.dyplomapp.util.Constants.REGISTER_REQUEST
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface DatabaseApi {

    @POST(INVITE_CODE_REQUEST)
    suspend fun checkInviteCode(@Body inviteCode: String): Response<SimpleRequest>

    @POST(REGISTER_REQUEST)
    suspend fun registerUser(@Body userData: UserData): Response<SimpleRequest>

    companion object{
        const val BASE_URL = "http://192.168.1.6:8080"
    }
}