package com.myapps.simplecaching.data

import androidx.room.withTransaction
import com.myapps.simplecaching.api.RestaurantApi
import com.myapps.simplecaching.util.netWorkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class Repository  @Inject constructor(
    private val api:RestaurantApi,
    private val db :RestaurantDataBase
) {

    private val restaurantDao = db.restaurantDao()

    fun getRestaurant()= netWorkBoundResource(
        query = {
            restaurantDao.getAllRestaurants()
        },
        fetch = {
            delay(2000)
            api.getAllRestaurants()
        },
        saveFetchResult = {
            db.withTransaction {
                restaurantDao.deleteAll()
                restaurantDao.insertIntoRestaurantTable(it)
            }
        }
    )
    
}