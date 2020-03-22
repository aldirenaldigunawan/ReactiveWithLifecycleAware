package com.example.reactivewithlifecycleaware.presentation.di

import com.example.reactivewithlifecycleaware.presentation.ReactiveApplication
import com.example.reactivewithlifecycleaware.presentation.di.modules.ApplicationModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [
        ApplicationModule::class,
        AndroidInjectionModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<ReactiveApplication> {

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent
    }
}