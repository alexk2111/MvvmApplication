package com.sigmasoftware.akucherenko.mvvmapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

import com.sigmasoftware.akucherenko.mvvmapplication.databinding.ActivityMainBinding
import com.sigmasoftware.akucherenko.mvvmapplication.model.Item

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val viewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel.getUsers().observe(this, Observer<List<Item>>{ items ->
        viewModel.items.observe(this, Observer<List<Item>> { items ->
            // update UI
            binding.textViewItems.text = items.joinToString(separator = "\n")
        })

        binding.buttonShowItems.setOnClickListener() {
            viewModel.getUsers()
        }

        binding.buttonAddItem.setOnClickListener() {
            viewModel.addItem(
                binding.editTextId.text.toString().toInt(),
                binding.editTextName.text.toString()
            )
            binding.editTextId.text = null
            binding.editTextName.text = null
        }
    }
}