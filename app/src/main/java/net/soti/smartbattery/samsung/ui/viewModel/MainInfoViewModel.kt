package net.soti.smartbattery.samsung.ui.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.soti.smartbattery.samsung.SamsungApplication

class MainInfoViewModel : ViewModel() {
    val context = SamsungApplication.instance
    private var _connStatus = MutableStateFlow(false)
    val connStatus = _connStatus.asStateFlow()
    /*private var connectionReceiver: XtsConnectionReceiver? = null

    private val _mainInfo = MutableStateFlow(
        MainInfoData(
            model = Constants.EMPTY_STRING,
            osVersion = Constants.EMPTY_STRING,
            manufacturer = Constants.EMPTY_STRING,
            serialNo = Constants.EMPTY_STRING,
            partNo = Constants.EMPTY_STRING,
            mfdDate = Constants.EMPTY_STRING,
            ratedCapacity = -1,
            socketVersionName = Constants.EMPTY_STRING,
            xtsVersion = Constants.EMPTY_STRING
        )
    )

    *//**
     * Registers [XtsConnectionReceiver] to update XTS Connection status.
     *//*
    fun registerXtsReceiver(mainView: MainView) {
        connectionReceiver = XtsConnectionReceiver(mainView)
        val intentFilter = IntentFilter()
        intentFilter.addAction(XTSocket.XTS_CONNECTED)
        intentFilter.addAction(XTSocket.XTS_DISCONNECTED)
        context.registerReceiver(connectionReceiver, intentFilter)
    }

    *//**
     * Unregisters [XtsConnectionReceiver] when app stops.
     *//*
    fun unregisterXtsReceiver() {
        if (connectionReceiver != null) {
            context.unregisterReceiver(connectionReceiver)
        }
    }

    fun getInfoList(): List<Info> = listOf(
        Info(
            R.drawable.ic_device,
            context.resources.getString(R.string.device_info),
            listOf(
                context.resources.getString(R.string.device_model) + _mainInfo.value.model,
                context.resources.getString(R.string.device_os) + _mainInfo.value.osVersion,
                context.resources.getString(R.string.manufacture) + _mainInfo.value.manufacturer
            )
        ),
        Info(
            R.drawable.ic_smart_battery, context.resources.getString(R.string.battery_info),
            listOf(
                context.resources.getString(R.string.serial_number) + _mainInfo.value.serialNo,
                context.resources.getString(R.string.part_number) + _mainInfo.value.partNo,
                context.resources.getString(R.string.mfd_date) + _mainInfo.value.mfdDate,
                context.resources.getString(R.string.rated_capacity) + _mainInfo.value.ratedCapacity + Constants.MAH
            )
        ),
        Info(
            R.drawable.ic_agent_version,
            context.resources.getString(R.string.socket_version_title),
            listOf(
                context.resources.getString(R.string.app_version) + _mainInfo.value.socketVersionName,
                context.resources.getString(R.string.xts_version) + _mainInfo.value.xtsVersion
            )
        )
    )

    *//**
     * Update data on MainActivity UI.
     *//*
    fun setInfo() {
        viewModelScope.launch { //todo may be need to check usage
            val batteryCollector = BatteryCollector()
            val mainInfo = MainInfoData(
                Build.MODEL,
                Build.VERSION.RELEASE,
                Build.MANUFACTURER,
                batteryCollector.getSerial(),
                batteryCollector.getPartNo(),
                batteryCollector.getMfdDate(),
                batteryCollector.getRatedCapacity(), //Todo handle dataType
                Util.getAppVersionName(),
                Util.getSockInfo()
            )
            _mainInfo.update { mainInfo }
        }
    }*/

    fun updateConnectionStatus(isConnected: Boolean) {
        _connStatus.update { isConnected }
    }
}