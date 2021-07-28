package com.myapps.simplecaching.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {
    @Query("Select * From restaurant_table")
    fun getAllRestaurants(): Flow<List<Restaurant>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIntoRestaurantTable(restaurants: List<Restaurant>)

    @Query("DELETE FROM restaurant_table")
    suspend fun deleteAll()
}