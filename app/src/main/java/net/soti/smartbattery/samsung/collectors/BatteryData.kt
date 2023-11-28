package net.soti.smartbattery.samsung.collectors

import net.soti.smartbattery.samsung.constants.Constants

abstract class BatteryData(private val uniqueId: String?) : BaseBatteryData() {

    companion object {
        //Common API in all Zebra smart batteries.
        const val MANUFACTURE_DATE = "mfd"
        const val SERIAL_NO = "serialnumber"
        const val CYCLE_COUNT = "battery_usage_numb"
        const val RATED_CAP = "ratedcapacity"
        const val PART_NO = "partnumber"
        const val BATTERY_TYPE = "battery_type"
        const val BATTERY_DECOMMISSION = "battery_decommission"
        const val TOTAL_CUMULATIVE_CHARGE = "total_cumulative_charge"

        // APIs coming under battery type Power Precision Plus.
        const val HEALTH_PERCENT = "health_percentage"
        const val CURRENT_CAP = "present_capacity"
        const val CURRENT_CHRG = "present_charge"
        const val BASE_CUMULATIVE_CHARGE = "base_cumulative_charge"
        const val SECONDS_SINCE_FIRST_USE = "seconds_since_first_use"
        const val TIME_TO_EMPTY = "time_to_empty"
        const val TIME_TO_FULL = "time_to_full"

        //Battery Types.
        const val POWER_PRECISION_PLUS = 201
        val POWER_PRECISION = arrayOf(202, 206)
    }

    protected fun serial() = super.getString(SERIAL_NO, Constants.EMPTY_STRING)

    protected fun mfdDate() = super.getString(MANUFACTURE_DATE, Constants.EMPTY_STRING)

    protected fun partNo() = super.getString(PART_NO, Constants.EMPTY_STRING)

    protected fun healthPercentage() = super.getInt(HEALTH_PERCENT, -1)

    protected fun cycleCount() = super.getInt(CYCLE_COUNT, -1)

    protected fun ratedCapacity() = super.getInt(RATED_CAP, -1)

    protected fun currentCapacity() = super.getInt(CURRENT_CAP, -1)

    protected fun currentCharge() = super.getInt(CURRENT_CHRG, -1)

    protected fun batteryType() = super.getInt(BATTERY_TYPE, -1)

    protected fun decomStatus() = super.getInt(BATTERY_DECOMMISSION, -1)

    protected fun baseCumCharge() = super.getInt(BASE_CUMULATIVE_CHARGE, -1)

    protected fun totalCumCharge() = super.getInt(TOTAL_CUMULATIVE_CHARGE, -1)

    protected fun timeToEmpty() = super.getInt(TIME_TO_EMPTY, -1)

    protected fun timeToFull() = super.getInt(TIME_TO_FULL, -1)

    protected fun secSinceFirstUse() = super.getInt(SECONDS_SINCE_FIRST_USE, -1)
}