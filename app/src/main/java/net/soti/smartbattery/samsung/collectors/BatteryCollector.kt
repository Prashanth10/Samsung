package net.soti.smartbattery.samsung.collectors

import android.annotation.SuppressLint

import net.soti.smartbattery.samsung.constants.Constants
import net.soti.smartbattery.samsung.interfaces.IBatteryData
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.regex.Pattern

class BatteryCollector(uniqueId: String? = null) : BatteryData(uniqueId), IBatteryData {

    override fun getBatteriesInfo(): JSONArray {
        val batteriesInfo = JSONArray()
        val batteryInfoJson = JSONObject()
        batteryInfoJson.put(Constants.MFG_BATTERY_ID, getMfgBatteryId())
        batteryInfoJson.put(Constants.MANUFACTURE_DATE, getMfdDate())
        batteryInfoJson.put(Constants.SERIAL_NO, getSerial())
        batteryInfoJson.put(Constants.CYCLE_COUNT, getCycleCount())
        batteryInfoJson.put(Constants.RATED_CAP, getRatedCapacity())
        batteryInfoJson.put(Constants.PART_NO, getPartNo())
        batteryInfoJson.put(Constants.FIRST_USED_DATE, getFirstUsedDate())
        if (getBatteryTypeRaw() == POWER_PRECISION_PLUS) {
            batteryInfoJson.put(Constants.HEALTH_PERCENT, getHealthPercentage())
            batteryInfoJson.put(Constants.CURRENT_CAP, getCurrentCapacity())
            batteryInfoJson.put(Constants.CURRENT_CHRG, getCurrentCharge())

        }
        batteriesInfo.put(batteryInfoJson)
//        Log.d("getBatteriesInfo: $batteriesInfo", true)
        return batteriesInfo
    }

    override fun isSmartBattery(): Boolean {
        val btyType = super.batteryType()
        val isSmartBty = (btyType == POWER_PRECISION_PLUS || POWER_PRECISION.contains(btyType))
//        Log.d("isSmartBattery: $isSmartBty")
        return isSmartBty
    }

    override fun getMfgBatteryId() = super.serial().plus(super.partNo()).plus(super.mfdDate())

    override fun getSerial() = super.serial()

    override fun getMfdDate(): String {
        val mfdDate = super.mfdDate()
        return if (Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})").matcher(mfdDate).matches()) mfdDate
        else mfdDate.replace("(\\d{4})(\\d{2})(\\d{2})".toRegex(), "$1-$2-$3")
    }

    override fun getHealthPercentage() = super.healthPercentage()

    override fun getCycleCountRaw() = super.cycleCount()

    override fun getCycleCount(): Int {
        return if (POWER_PRECISION.contains(super.batteryType())) {
            super.cycleCount()
        } else {
            val totalCumulativeCharge = getMedianOf(Constants.TOTAL_CUM_CHRG)
            val ratedCapacity = getMedianOf(Constants.RATED_CAP)
            val currentCapacity = getMedianOf(Constants.CURRENT_CAP)
            return if (totalCumulativeCharge == -1 || ratedCapacity == -1 || currentCapacity == -1) -1
            else totalCumulativeCharge / ((ratedCapacity + currentCapacity) / 2)
        }
    }

    private fun getMedianOf(property: String): Int {
        val medianArray = mutableListOf<Int>()
        for (i in 1..9) {
            intent = super.register()
            medianArray.add(
                when (property) {
                    Constants.TOTAL_CUM_CHRG -> super.totalCumCharge()
                    Constants.RATED_CAP -> super.ratedCapacity()
                    Constants.CURRENT_CAP -> super.currentCapacity()
                    else -> 0
                }
            )
        }
        return medianArray.sorted().let { it[it.size / 2] }
    }

    override fun getCurrentCapacity() = super.currentCapacity()

    override fun getCurrentCharge() = super.currentCharge()

    override fun getRatedCapacity() = super.ratedCapacity()

    override fun getPartNo(): String = super.partNo()

    @SuppressLint("SimpleDateFormat")
    override fun getFirstUsedDate(): String {
        val firstUsedDate = System.currentTimeMillis() - super.secSinceFirstUse().toLong() * 1000
        return SimpleDateFormat("yyyy-MM-dd").format(firstUsedDate)
    }

    override fun getBatteryTypeRaw() = super.batteryType()
    override fun getBatteryType(): String {
        TODO("Not yet implemented")
    }

    override fun getDecomStatusRaw(): Int {
        TODO("Not yet implemented")
    }

    override fun getDecomStatus(): String {
        TODO("Not yet implemented")
    }

    /*override fun getBatteryType(): String {
        return when (val type = super.batteryType()) {
            201 -> getResource(R.string.power_precision_plus, type)
            202, 206 -> getResource(R.string.power_precision, type)
            else -> getResource(R.string.empty, type)
        }
    }

    override fun getDecomStatusRaw() = super.decomStatus()

    override fun getDecomStatus(): String {
        return when (val stat = super.decomStatus()) {
            0 -> getResource(R.string.decom_stat_good, stat)
            1 -> getResource(R.string.decom_stat_decommissioned, stat)
            2 -> getResource(R.string.decom_stat_unknown, stat)
            else -> getResource(R.string.empty, stat)
        }
    }*/

    override fun getTotalCumCharge() = super.totalCumCharge()

    override fun getBaseCumCharge() = super.baseCumCharge()

    override fun getTimeToEmptyRaw() = super.timeToEmpty()

    override fun getTimeToEmpty(): Int {
        val timeToEmpty = super.timeToEmpty()
        return if (timeToEmpty != -1) timeToEmpty * Constants.ONE_MINUTE
        else timeToEmpty
    }

    override fun getTimeToFullRaw() = super.timeToFull()

    override fun getTimeToFull(): Int {
        val timeToFull = super.timeToFull()
        return if (timeToFull != -1) timeToFull * Constants.ONE_MINUTE
        else timeToFull
    }

    override fun getSecSinceFirstUse() = super.secSinceFirstUse()

    override fun clear() = super.clearData()
}