package com.example.reactivewithlifecycleaware.presentation.data.local

import com.example.reactivewithlifecycleaware.presentation.data.local.dao.SomeDao
import javax.inject.Inject

interface AppDatabase {
    fun getSomeDao(): SomeDao
}

class AppDatabaseImpl @Inject constructor(
    private val database: ActualDatabase
) : AppDatabase {
    override fun getSomeDao(): SomeDao = database.someDao()
}