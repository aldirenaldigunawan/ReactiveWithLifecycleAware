package com.example.reactivewithlifecycleaware.presentation.di.modules

import com.example.reactivewithlifecycleaware.presentation.data.remote.Api
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@Module
class NetworkModule {

    @Provides
    fun provideApi(retrofit: Retrofit) =
        retrofit.create(Api::class.java)

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(SERVER_PATH)
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }

    companion object {
        const val SERVER_PATH = ""
    }
}