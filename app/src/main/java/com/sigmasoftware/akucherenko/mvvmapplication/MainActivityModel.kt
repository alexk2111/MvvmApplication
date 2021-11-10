package com.sigmasoftware.akucherenko.mvvmapplication

import com.sigmasoftware.akucherenko.mvvmapplication.model.Item
import com.sigmasoftware.akucherenko.mvvmapplication.model.MockGenerator
import kotlinx.coroutines.*

class MainActivityModel {
    val items = MockGenerator.generateItems(3)

    fun addItem(id: Int, name: String) {
        items.add(Item(id, name))
    }
}