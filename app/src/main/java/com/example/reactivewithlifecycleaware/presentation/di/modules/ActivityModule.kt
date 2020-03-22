package com.example.reactivewithlifecycleaware.presentation.di.modules

import com.example.reactivewithlifecycleaware.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule{

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity
}

@Module
class MainActivityModule{

}