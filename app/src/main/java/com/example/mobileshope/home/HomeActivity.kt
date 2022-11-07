package com.example.mobileshope.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileshope.databinding.ActivityHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel by viewModel<HomeViewModel>()

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.content.observe(this) {
        }


    }
}