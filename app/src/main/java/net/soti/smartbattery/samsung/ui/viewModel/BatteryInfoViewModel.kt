package net.soti.smartbattery.samsung.ui.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import net.soti.smartbattery.samsung.collectors.BatteryCollector
import net.soti.smartbattery.samsung.constants.UIConst
import net.soti.smartbattery.samsung.models.RawData

class BatteryInfoViewModel : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()
    var batteryInfoList = mutableStateOf(getList())

    fun loadBatteryData() {
        viewModelScope.launch {
            _isLoading.value = true
            delay(500)
            batteryInfoList.value = getList()
            _isLoading.value = false
        }
    }

    private fun getList(): List<RawData> {
        val batteryCollector = BatteryCollector()
        val list = mutableListOf<RawData>()
        list.clear()
        list.add(RawData(UIConst.BATTERY_TYPE, batteryCollector))
        list.add(RawData(UIConst.MFD_DATE, batteryCollector))
        list.add(RawData(UIConst.PART_NO, batteryCollector))
        list.add(RawData(UIConst.SERIAL_NO, batteryCollector))
        list.add(RawData(UIConst.RATED_CAP, batteryCollector))
        list.add(RawData(UIConst.DECOM_STAT, batteryCollector))
        list.add(RawData(UIConst.CYC_COUNT, batteryCollector))
        list.add(RawData(UIConst.CURRENT_CAP, batteryCollector))
        list.add(RawData(UIConst.CURRENT_CHRG, batteryCollector))
        list.add(RawData(UIConst.HEALTH_PERCENT, batteryCollector))
        list.add(RawData(UIConst.TIME_FULL, batteryCollector))
        list.add(RawData(UIConst.TIME_EMPTY, batteryCollector))
        list.add(RawData(UIConst.TOTAL_CUM_CHRG, batteryCollector))
        list.add(RawData(UIConst.BASE_CUM_CHRG, batteryCollector))
        list.add(RawData(UIConst.SEC_SINC_FRST_USE, batteryCollector))
        return list
    }
}