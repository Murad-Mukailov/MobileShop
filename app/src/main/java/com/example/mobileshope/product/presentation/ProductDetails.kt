package com.example.mobileshope.product.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileshope.R
import com.example.mobileshope.databinding.ActivityProductDetailsBinding

class ProductDetails : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}