package net.soti.smartbattery.samsung

import android.app.Application

class SamsungApplication : Application() {
    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}