package com.myapps.simplecaching.di


import android.app.Application
import androidx.room.Room
import com.myapps.simplecaching.api.RestaurantApi
import com.myapps.simplecaching.data.RestaurantDataBase
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
    fun provideApi(retrofit: Retrofit): RestaurantApi =
        retrofit.create(RestaurantApi::class.java)


    @Provides
    @Singleton
    fun provideDataBase(app: Application): RestaurantDataBase =
        Room.databaseBuilder(app, RestaurantDataBase::class.java, "restaurantDb").build()
}