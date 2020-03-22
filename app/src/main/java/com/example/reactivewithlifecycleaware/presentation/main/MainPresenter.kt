package com.example.reactivewithlifecycleaware.presentation.main

import android.util.Log
import com.example.reactivewithlifecycleaware.presentation.data.DataRepository
import com.example.reactivewithlifecycleaware.util.CarModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.SerialDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val repository: DataRepository
) : MainContract.Presenter {

    private var layoutType =
        MainContract.LayoutType.Linear
    private lateinit var view: MainContract.View
    private val serialDisposable = SerialDisposable()

    override fun attachView(view: MainContract.View) {
        this.view = view
        loadUsers()
    }

    override fun changeLayout(type: MainContract.LayoutType) {
        this.layoutType = type
        loadUsers()
    }

    private fun loadUsers() {
        repository.getData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                when (layoutType) {
                    MainContract.LayoutType.Linear -> {
                        view.renderListView(it.mapToLinearViewObject())
                        view.changeListToLinear()
                    }
                    MainContract.LayoutType.Grid -> {
                        view.renderListView(it.mapToGridViewObject())
                        view.changeListToGrid()
                    }
                    MainContract.LayoutType.Single -> view.renderSingleView(it)
                }
            }, {
                Log.d("MainActivity", "error fetch : ${it.message}")
            }).let(serialDisposable::set)

    }

    private fun List<CarModel>.mapToLinearViewObject(): List<MainContract.ListViewObject.Linear> {
        return this.map { MainContract.ListViewObject.Linear(it) }
    }

    private fun List<CarModel>.mapToGridViewObject(): List<MainContract.ListViewObject.Grid> {
        return this.map { MainContract.ListViewObject.Grid(it) }
    }

    override fun detachView() {
        serialDisposable.dispose()
    }
}