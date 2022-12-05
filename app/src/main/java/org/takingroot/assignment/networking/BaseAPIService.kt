package org.takingroot.assignment.networking

import org.takingroot.assignment.models.Survey
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface BaseAPIService {
    @POST("survey/{type}")
    suspend fun response(@Path("type") type: String, @Body survey: Survey): Response<Void>
}

class RetrofitInstance {
    companion object {
        fun getInstance(): BaseAPIService {
            return Retrofit.Builder()
                .baseUrl("https://assignments.takingroot.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BaseAPIService::class.java)
        }
    }
}