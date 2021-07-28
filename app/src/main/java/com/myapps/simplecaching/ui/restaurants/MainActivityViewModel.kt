package com.myapps.simplecaching.ui.restaurants

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.myapps.simplecaching.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel  @Inject constructor(
    repository: Repository
):ViewModel() {


    val restaurantLiveData = repository.getRestaurant().asLiveData()
}