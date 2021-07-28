package com.myapps.simplecaching.ui.restaurants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapps.simplecaching.databinding.ActivityMainBinding
import com.myapps.simplecaching.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel:MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurantAdapter =RestaurantAdapter()

        binding.apply {
            restaurantsRecycler.adapter = restaurantAdapter
            restaurantsRecycler.layoutManager = LinearLayoutManager(this@MainActivity)

            viewModel.restaurantLiveData.observe(this@MainActivity){ result ->
                restaurantAdapter.submitList(result.data)

                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                errorTxt.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                errorTxt.text = result.error.toString()
                
            }
        }


    }
}