package com.myapps.simplecaching.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="restaurant_table")
 data class Restaurant(
    @PrimaryKey val name:String,
    val type:String,
    val logo:String,
    val address:String
 ) {
}