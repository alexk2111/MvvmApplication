package com.sigmasoftware.akucherenko.mvvmapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sigmasoftware.akucherenko.mvvmapplication.model.Item

class ItemViewModel: ViewModel() {

    private val model = MainActivityModel()

    var items = MutableLiveData<MutableList<Item>>()

    fun getUsers() {
        items.postValue(loadItems())
    }

    private fun loadItems(): MutableList<Item> {
        return model.items
    }

    fun addItem(id: Int, name: String) {
        model.addItem(id, name)
        items.postValue(loadItems())

    }

}