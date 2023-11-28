package net.soti.smartbattery.samsung.models

import net.soti.smartbattery.samsung.constants.Constants.EMPTY_STRING
import net.soti.smartbattery.samsung.interfaces.IBatteryData

class RawData(val title: String, bd: IBatteryData) {
    var value: String = when (title) {
        /*UIConst.SERIAL_NO -> getResource(R.string.serial_no, bd.getSerial())
        UIConst.MFD_DATE -> getResource(R.string.mfg_date, bd.getMfdDate())
        UIConst.CYC_COUNT -> getResource(R.string.cycle_count, bd.getCycleCount())
        UIConst.HEALTH_PERCENT -> getResource(R.string.health_percent, bd.getHealthPercentage())
        UIConst.PART_NO -> getResource(R.string.part_no, bd.getPartNo())
        UIConst.CURRENT_CAP -> getResource(R.string.current_cap, bd.getCurrentCapacity())
        UIConst.CURRENT_CHRG -> getResource(R.string.current_chrg, bd.getCurrentCharge())
        UIConst.RATED_CAP -> getResource(R.string.rated_cap, bd.getRatedCapacity())
        UIConst.BATTERY_TYPE -> getResource(R.string.battery_type, bd.getBatteryType())
        UIConst.DECOM_STAT -> getResource(R.string.decom_stat, bd.getDecomStatus())
        UIConst.TIME_EMPTY -> getResource(R.string.time_empty, bd.getTimeToEmptyRaw())
        UIConst.TIME_FULL -> getResource(R.string.time_full, bd.getTimeToFullRaw())
        UIConst.TOTAL_CUM_CHRG -> getResource(R.string.total_cum_chrg, bd.getTotalCumCharge())
        UIConst.BASE_CUM_CHRG -> getResource(R.string.base_cum_chrg, bd.getBaseCumCharge())
        UIConst.SEC_SINC_FRST_USE -> getResource(
            R.string.sec_sinc_frst_use,
            bd.getSecSinceFirstUse()
        )*/
        else -> EMPTY_STRING
    }
}