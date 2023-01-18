package com.example.mobileshope.details.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileshope.R
import com.example.mobileshope.databinding.ActivityHomeBinding
import com.example.mobileshope.databinding.ActivityProductsDetailsBinding

class ProductsDetails : AppCompatActivity() {
    private lateinit var binding: ActivityProductsDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProductsDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}