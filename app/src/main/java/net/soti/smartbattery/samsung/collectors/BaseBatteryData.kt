package net.soti.smartbattery.samsung.collectors

import android.content.Intent
import android.content.IntentFilter
import net.soti.smartbattery.samsung.SamsungApplication

abstract class BaseBatteryData {
    var intent = register()

    /**
     * Registers a sticky intent to collect battery data.
     */
    protected fun register(): Intent? {
//        Log.d("register receiver", true)
        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        return SamsungApplication.instance.registerReceiver(null, intentFilter)
    }

    /**
     * Returns the bundle that contains data for all the API.
     */
    private fun values() = intent?.extras

    /**
     * Returns data of the [property] from intent extras that has a return type [String].
     */
    protected fun getString(property: String, defaultValue: String): String {
        val data = values()?.getString(property, defaultValue) ?: defaultValue
//        Log.d("getString $property : $data")
        return data
    }

    /**
     * Returns data of the [property] from intent extras that has a return type [Int].
     */
    protected fun getInt(property: String, defaultValue: Int): Int {
        val data = values()?.getInt(property, defaultValue) ?: defaultValue
//        Log.d("getInt $property : $data")
        return data
    }

    /**
     *This method clears the sticky [intent] to null.
     */
    protected fun clearData() {
//        Log.d("clearData: set intent as null", true)
        intent = null
    }
}