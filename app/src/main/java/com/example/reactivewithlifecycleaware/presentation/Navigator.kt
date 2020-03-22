package com.example.reactivewithlifecycleaware.presentation

import android.content.Context
import com.example.reactivewithlifecycleaware.presentation.main.MainActivity

fun Context.startMain() {
    this.startActivity(
        MainActivity.createIntent(
            this
        )
    )
}