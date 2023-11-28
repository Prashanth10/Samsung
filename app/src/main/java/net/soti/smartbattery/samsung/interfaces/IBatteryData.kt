package net.soti.smartbattery.samsung.interfaces

import org.json.JSONArray

interface IBatteryData {
    /**
     * @return [JSONArray] that contains all the required battery related data.
     */
    fun getBatteriesInfo(): JSONArray

    /**
     * Checks if the battery inside the device is a smartbattery by checking the battery type(power precision plus or power precision.
     *
     * Power precision plus: [getBatteryType] = 201
     *
     * Power precision: [getBatteryType] = 202 or 206
     */
    fun isSmartBattery(): Boolean

    /**
     * Unique ID for the battery which is a combination of [getSerial], [getPartNo] and [getMfdDate]
     */
    fun getMfgBatteryId(): String

    /**
     * Serial Number of the battery. Matches the value on the physical battery label. Used to identify the number of batteries produced in a day.
     */
    fun getSerial(): String

    /**
     * The date when the battery was manufactured (yyyy-mm-dd).
     */
    fun getMfdDate(): String

    /**
     * Battery health indicator in percentage (0 to 100).
     */
    fun getHealthPercentage(): Int

    /**
     *Number of charge cycles. The cycle becomes increment by 1 when the total charge capacity meets the present capacity. 300-500 cycles: Zebra recommends that  the battery is changed.If cycle > 300 = unhealthy (decommission status = 1). The default cycle values can be changed by the customer.Only available in PP.
     */
    fun getCycleCountRaw(): Int

    /**
     * Method to calculate cycle count for power precision plus batteries as cycle count is available only for power precision batteries. Calculated using [getRatedCapacity], [getTotalCumCharge] and [getCurrentCapacity].
     */
    fun getCycleCount(): Int

    /**
     * Maximum amount of charge that could be pulled from the battery under the present discharge conditions if the battery is fully charged. It's decreasing when the battery gets aged.Returns value in mAh.Only available in PP+.
     */
    fun getCurrentCapacity(): Int

    /**
     * Amount of usable charge remaining in the battery under current discharge conditions. Returns value in mAh.Only available in PP+.
     */
    fun getCurrentCharge(): Int

    /**
     * Rated capacity of the battery or battery capacity on label.Returns value in mAh.
     */
    fun getRatedCapacity(): Int

    /**
     * Represents a number for that pack. The batteries with same partnumber have the same cell  etc. Partnumber is not unique, it is unique to a family of batteries.Format of part number is Prefix-5 or 6 #s-suffix revision.
     */
    fun getPartNo(): String

    /**
     * First used date of the battery. Currently, it returns an empty string.
     */
    fun getFirstUsedDate(): String

    /**
     * Type of the battery. Either power precision plus (201) or power precision (202 or 206) batteries.
     * @return Integer value
     */
    fun getBatteryTypeRaw(): Int

    /**
     * Returns the corresponding string value for the battery type.
     *
     * @return :"Power precision plus" if [getBatteryType] is 201.
     *
     * "Power Precision" if [getBatteryType] is 202 or 206.
     *
     * Empty string if none of the above.
     */
    fun getBatteryType(): String

    /**
     * Decommission status of the battery. The value is based on health_percentage or battery_usage_numb.
     */
    fun getDecomStatusRaw(): Int

    /**
     * Returns the status as a string based on the decommission status value.
     *
     * @return one of the following mentioned below:
     *
     * 0=Battery good
     *
     * 1=Decommissioned Battery
     *
     * 2=Status Unknown
     */
    fun getDecomStatus(): String

    /**
     * Cumulative charge using ALL (Zebra or Non-Zebra) charging equipment. The value will get updated in every charging.
     */
    fun getTotalCumCharge(): Int

    /**
     * Cumulative charge using Zebra charging equipment only. This value will increase only if the device is charging using Zebra equipment.Only available in PP+.
     */
    fun getBaseCumCharge(): Int

    /**
     * Remaining time until the device becomes unusable under current discharge conditions. Predicted remaining time to fully discharge the battery based on average current by FG.Returns value in seconds.Only available in PP+.
     */
    fun getTimeToEmptyRaw(): Int

    /**
     * @return Time to empty value in minutes.
     */
    fun getTimeToEmpty(): Int

    /**
     * Time until battery is fully charged under present charging conditions. The predicted remaining time to achieve full charge based on average current by FG.Returns value in seconds.Only available in PP+.
     */
    fun getTimeToFullRaw(): Int

    /**
     * @return Time to full value in minutes.
     */
    fun getTimeToFull(): Int

    /**
     * Number of seconds passed since the battery was placed in a charger/terminal for the first time. This is the value since the battery was first inserted in the device by the customer. Returns value in seconds.Only available in PP+.
     */
    fun getSecSinceFirstUse(): Int

    /**
     * Clears the previously set intent.
     */
    fun clear()
}