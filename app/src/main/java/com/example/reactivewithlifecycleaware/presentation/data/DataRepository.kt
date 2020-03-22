package com.example.reactivewithlifecycleaware.presentation.data

import com.example.reactivewithlifecycleaware.presentation.data.remote.Api
import com.example.reactivewithlifecycleaware.util.CarModel
import com.example.reactivewithlifecycleaware.util.Data
import io.reactivex.Single
import javax.inject.Inject

interface DataRepository {
    fun getData(): Single<List<CarModel>>
}

class DataRepositoryImpl @Inject constructor(
    private val api: Api
) : DataRepository {
    override fun getData(): Single<List<CarModel>> {
        return Single.just(Data.getCarModels())
    }
}