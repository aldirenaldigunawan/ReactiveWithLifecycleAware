package com.example.reactivewithlifecycleaware.presentation.data.local

import com.example.reactivewithlifecycleaware.presentation.data.local.dao.SomeDao
import java.util.*

class ActualDatabase {
    fun someDao(): SomeDao {
        return object :
            SomeDao {
            override fun getString(): String {
                return UUID.randomUUID().toString()
            }
        }
    }
}