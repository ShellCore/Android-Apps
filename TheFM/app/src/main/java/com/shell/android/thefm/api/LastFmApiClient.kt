package com.shell.android.thefm.api

import com.shell.android.thefm.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class LastFmApiClient {

    companion object {
        const val BASE_URL = BuildConfig.LASTFM_BASE_URL
        const val API_KEY = BuildConfig.LASTFM_API_KEY
    }

    @Provides
    fun provideApiService(): LastFmService {
        return provideRetrofit(BASE_URL, provideClient())
            .create(LastFmService::class.java)
    }

    @Provides
    fun provideRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provideClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = when {
            BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
            else -> HttpLoggingInterceptor.Level.NONE
        }

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(object: Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    var request = chain.request()
                    val url = request.url
                        .newBuilder()
                        .addQueryParameter("api_key", API_KEY)
                        .addQueryParameter("format", "json")
                        .build()
                    request = request.newBuilder()
                        .url(url)
                        .build()
                    return chain.proceed(request)
                }
            })
            .build()
    }
}