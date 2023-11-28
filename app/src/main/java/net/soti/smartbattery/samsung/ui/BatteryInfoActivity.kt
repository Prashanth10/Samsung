package net.soti.smartbattery.samsung.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import net.soti.smartbattery.samsung.ui.composables.BatteryInfoCompose

class BatteryInfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BatteryInfoCompose()
        }
    }
}