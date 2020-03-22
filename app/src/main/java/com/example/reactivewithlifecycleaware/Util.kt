package com.example.reactivewithlifecycleaware

import android.content.Context
import android.util.DisplayMetrics
import kotlin.math.roundToInt


fun Context.dpToPx(dp: Int): Int {
    val displayMetrics: DisplayMetrics = resources.displayMetrics
    return (dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
}
