package com.sigmasoftware.akucherenko.mvvmapplication.model

import java.util.*

class MockGenerator {
    companion object {
        @JvmStatic
        public fun generateItems(count: Int): MutableList<Item> {
            val items: MutableList<Item> = mutableListOf()
            for (i in 0 until count) {
                items.add(Item(i, UUID.randomUUID().toString()))
            }
            return items
        }
    }
}