package com.angelstudio.football.DI.Module

import com.angelstudio.football.BuildConfig
import com.angelstudio.football.Util.scheduler.SchedulerProvider
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {

    companion object {
        const val HEADER_AUTHORIZATION = "X-Auth-Token"
        const val HEADER_CONTENT_TYPE = "Content-Type"
        const val HEADER_CONTENT_TYPE_VALUE = "application/json"
        const val CONNECT_TIMEOUT: Long = 60
        const val READ_TIMEOUT: Long = 60
        const val WRITE_TIMEOUT: Long = 60
        const val API_KEY = BuildConfig.API_KEY

    }



    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    fun provideInterceptor(): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
           requestBuilder.header(
                HEADER_CONTENT_TYPE,
                HEADER_CONTENT_TYPE_VALUE
            )
            requestBuilder.header(
                HEADER_AUTHORIZATION, API_KEY
            )
            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        interceptor: Interceptor
    ): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(httpLoggingInterceptor)
        httpClient.addInterceptor(interceptor)
        httpClient.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        httpClient.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        httpClient.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        return httpClient.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(httpClient: OkHttpClient, schedulerProvider: SchedulerProvider): Retrofit {

        return Retrofit.Builder().baseUrl("https://api.football-data.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(
                RxJava2CallAdapterFactory.createWithScheduler(schedulerProvider.io())
            )
            .client(httpClient)
            .build()
    }





}