package com.example.reactivewithlifecycleaware.presentation.main

import com.example.reactivewithlifecycleaware.util.CarModel
import com.example.reactivewithlifecycleaware.util.Data

class MainPresenter {

    private val carModels by lazy { Data.getCarModels() }
    private var layoutType =
        MainContract.LayoutType.Linear
    private lateinit var view: MainContract.View

    fun attachView(view: MainContract.View) {
        this.view = view
        loadCarModels()
    }

    fun changeLayout(type: MainContract.LayoutType) {
        this.layoutType = type
        loadCarModels()
    }

    private fun loadCarModels() {
        when (layoutType) {
            MainContract.LayoutType.Linear -> {
                view.renderListView(carModels.mapToLinearViewObject())
                view.changeListToLinear()
            }
            MainContract.LayoutType.Grid -> {
                view.renderListView(carModels.mapToGridViewObject())
                view.changeListToGrid()
            }
            MainContract.LayoutType.Single -> view.renderSingleView(carModels)
        }
    }

    private fun List<CarModel>.mapToLinearViewObject(): List<MainContract.ListViewObject.Linear> {
        return this.map { MainContract.ListViewObject.Linear(it) }
    }

    private fun List<CarModel>.mapToGridViewObject(): List<MainContract.ListViewObject.Grid> {
        return this.map { MainContract.ListViewObject.Grid(it) }
    }

    fun detachView() {

    }
}