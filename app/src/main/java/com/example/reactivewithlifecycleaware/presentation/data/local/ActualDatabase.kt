package com.example.reactivewithlifecycleaware.presentation.data.local

import com.example.reactivewithlifecycleaware.presentation.data.local.dao.SomeDao

class ActualDatabase {
    fun someDao(): SomeDao {
        return object :
            SomeDao {
            override fun getString(): String {
                return "Random"
            }
        }
    }
}