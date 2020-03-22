package com.example.reactivewithlifecycleaware.presentation.main

import com.example.reactivewithlifecycleaware.util.CarModel

interface MainContract {
    interface View {
        fun renderListView(carModel: List<ListViewObject>)
        fun changeListToLinear()
        fun changeListToGrid()
        fun renderSingleView(carModel: List<CarModel>)
    }

    interface Presenter {
        fun attachView(view: View)
        fun detachView()
        fun changeLayout(type: LayoutType)
    }

    enum class LayoutType {
        Linear, Grid, Single
    }

    sealed class ListViewObject(open val carModel: CarModel) {
        data class Linear(override val carModel: CarModel) : ListViewObject(carModel)
        data class Grid(override val carModel: CarModel) : ListViewObject(carModel)
    }
}