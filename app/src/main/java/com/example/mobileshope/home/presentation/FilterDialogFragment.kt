package com.example.mobileshope.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobileshope.databinding.FilterDialogFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FilterDialogFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FilterDialogFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.closeFilterButton.setOnClickListener { dismiss() }
    }
}