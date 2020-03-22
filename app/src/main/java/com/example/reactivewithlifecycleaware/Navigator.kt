package com.example.reactivewithlifecycleaware

import android.content.Context

fun Context.startMain() {
    this.startActivity(MainActivity.createIntent(this))
}