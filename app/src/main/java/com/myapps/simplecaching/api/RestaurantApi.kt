package com.myapps.simplecaching.api

import com.myapps.simplecaching.data.Restaurant
import retrofit2.http.GET

interface RestaurantApi {
companion object{
    val BASE_URL = "https://random-data-api.com/api/"
}

    @GET("restaurant/random_restaurant?size=20")
   fun getAllRestaurants():List<Restaurant>
}