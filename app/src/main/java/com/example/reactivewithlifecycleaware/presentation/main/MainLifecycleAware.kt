package com.example.reactivewithlifecycleaware.presentation.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

interface MainLifecycleAware : LifecycleObserver {
    fun registerLifecycle(lifecycle: Lifecycle)
    fun addListener(watcher: Watcher)

    interface Watcher {
        fun onResume()
        fun onPause()
        fun onDestroy()
    }
}

class MainLifecycleAwareImpl :
    MainLifecycleAware {
    private lateinit var lifecycle: Lifecycle
    private val watchers = mutableListOf<MainLifecycleAware.Watcher>()

    override fun registerLifecycle(lifecycle: Lifecycle) {
        this.lifecycle = lifecycle
        if (!this::lifecycle.isInitialized)
            this.lifecycle = lifecycle

        if (this.lifecycle != lifecycle) {
            destroy()
            this.lifecycle = lifecycle
        }
        this.lifecycle.addObserver(this)
    }

    override fun addListener(watcher: MainLifecycleAware.Watcher) {
        watchers.add(watcher)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause() = watchers.forEach { it.onPause() }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() = watchers.forEach { it.onResume() }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        watchers.forEach { it.onDestroy() }
        watchers.clear()
        lifecycle.removeObserver(this)
    }
}