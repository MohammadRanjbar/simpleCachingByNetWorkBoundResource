package com.myapps.simplecaching.di


import com.myapps.simplecaching.api.RestaurantApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder().baseUrl(RestaurantApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit):RestaurantApi =
        retrofit.create(RestaurantApi::class.java)
}