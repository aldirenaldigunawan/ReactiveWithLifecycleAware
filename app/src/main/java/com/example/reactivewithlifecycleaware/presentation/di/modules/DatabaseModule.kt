package com.example.reactivewithlifecycleaware.presentation.di.modules

import com.example.reactivewithlifecycleaware.presentation.data.local.ActualDatabase
import com.example.reactivewithlifecycleaware.presentation.data.local.AppDatabase
import com.example.reactivewithlifecycleaware.presentation.data.local.AppDatabaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class DatabaseModule {

    @Binds
    abstract fun bindAppDatabase(appDatabaseImpl: AppDatabaseImpl): AppDatabase

    companion object {
        @Provides
        fun provideActualDatabase(): ActualDatabase {
            return ActualDatabase()
        }
    }
}