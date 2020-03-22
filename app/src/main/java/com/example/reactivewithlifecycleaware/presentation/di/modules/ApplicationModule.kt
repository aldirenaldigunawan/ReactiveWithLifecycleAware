package com.example.reactivewithlifecycleaware.presentation.di.modules

import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class, ActivityModule::class])
class ApplicationModule { /* do something here */ }