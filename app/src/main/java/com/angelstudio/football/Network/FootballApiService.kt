package com.angelstudio.football.Network


import com.angelstudio.football.BuildConfig
import com.angelstudio.football.Model.Competitions
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


const val API_KEY = BuildConfig.API_DEVELOPER_FOOTBALL


interface FootballApiService {


    //@Headers("X-Auth-Token:"+ API_KEY)
    //@GET("competitions")
    //fun getcompetitions(@Query("plan") plan:String): Deferred<Competitions>

     @Headers("X-Auth-Token:"+ API_KEY)
     @GET("competitions")
     suspend fun getSet(@Query("plan") plan: String): Response<Competitions>


    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): FootballApiService {
            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                    .url
                    .newBuilder()
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(connectivityInterceptor)
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.football-data.org/v2/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FootballApiService::class.java)
        }
    }

}