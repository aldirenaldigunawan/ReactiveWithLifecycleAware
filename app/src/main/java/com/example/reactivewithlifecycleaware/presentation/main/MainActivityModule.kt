package com.example.reactivewithlifecycleaware.presentation.main

import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityModule{

    @Binds
    abstract fun bindPresenter(mainPresenter: MainPresenter): MainContract.Presenter
}