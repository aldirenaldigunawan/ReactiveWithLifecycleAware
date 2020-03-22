package com.example.reactivewithlifecycleaware.presentation

import android.util.Log
import com.example.reactivewithlifecycleaware.presentation.data.local.AppDatabase
import com.example.reactivewithlifecycleaware.presentation.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class ReactiveApplication : DaggerApplication() {

    @Inject
    lateinit var appDatabase: AppDatabase

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().build()
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("ReactiveApplication", appDatabase.getSomeDao().getString())
    }
}