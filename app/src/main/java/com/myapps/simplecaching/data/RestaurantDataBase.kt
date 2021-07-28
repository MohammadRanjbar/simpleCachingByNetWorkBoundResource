package com.myapps.simplecaching.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Restaurant::class],version = 1)
abstract class RestaurantDataBase :RoomDatabase() {

    abstract  fun restaurantDao() : RestaurantDao

}