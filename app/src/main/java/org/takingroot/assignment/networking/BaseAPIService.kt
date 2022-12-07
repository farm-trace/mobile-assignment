package org.takingroot.assignment.networking

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.takingroot.assignment.models.Survey
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface BaseAPIService {
    @POST("survey/{type}")
    suspend fun response(@Path("type") type: String, @Body survey: Survey): Response<Void>
}

class RetrofitInstance {
    companion object {
        private val accountIdInterceptor = Interceptor {
            val request = it.request()
                .newBuilder()
                .addHeader("account_id", "")
                .build()
            it.proceed(request)
        }

        private val client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(accountIdInterceptor)
            .build()

        fun getInstance(): BaseAPIService {
            return Retrofit.Builder().apply {
                baseUrl("http://assignment.takingroot.app")
                addConverterFactory(GsonConverterFactory.create())
                client(client)
            }.build().create(BaseAPIService::class.java)
        }
    }
}