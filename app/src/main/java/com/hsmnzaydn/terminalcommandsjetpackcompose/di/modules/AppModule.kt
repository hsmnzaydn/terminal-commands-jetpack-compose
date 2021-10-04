package com.hsmnzaydn.terminalcommandsjetpackcompose.di.modules

import android.content.Context
import com.hsmnzaydn.terminalcommandsjetpackcompose.utils.Config
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofitClient(@ApplicationContext context: Context): Retrofit {
        val cacheSize = 10 * 1024 * 1024
        val cache = Cache(context.cacheDir, cacheSize.toLong())

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .cache(cache)
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {

                    var request: Request =
                        chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer ${Config.authorazationKey}")
                            .addHeader("Accept", "application/json")
                            .addHeader("Accept-Encoding", "gzip, deflate")
                            .addHeader("User-Agent", "runscope/0.1")
                            .addHeader("Content-Type", "application/json")
                            .addHeader("app-language", "ENG")
                            .build()

                    return chain.proceed(request)
                }

            })
            .addInterceptor(loggingInterceptor)
            .build()
        return Retrofit.Builder().baseUrl("http://159.65.164.9:8090/api/").client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


}