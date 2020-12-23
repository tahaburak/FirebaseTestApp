package com.tahaburak.firebasetestapp

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner

/**
 * Created by burak on 23.12.2020
 */
class FirebaseTestApp : Application(), LifecycleObserver {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: FirebaseTestApp
            private set
    }

    var isForeground = false

    override fun onCreate() {
        super.onCreate()

        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onLifecycleEventStart() {
        isForeground = true
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onLifecycleEventStop() {
        isForeground = false
    }

}