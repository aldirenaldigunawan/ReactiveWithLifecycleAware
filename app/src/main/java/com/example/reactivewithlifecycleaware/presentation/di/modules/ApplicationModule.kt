package com.example.reactivewithlifecycleaware.presentation.di.modules

import com.example.reactivewithlifecycleaware.presentation.data.DataRepository
import com.example.reactivewithlifecycleaware.presentation.data.DataRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class, ActivityModule::class])
abstract class ApplicationModule {

    @Binds
    abstract fun bindDataRepository(repoImpl: DataRepositoryImpl): DataRepository
}