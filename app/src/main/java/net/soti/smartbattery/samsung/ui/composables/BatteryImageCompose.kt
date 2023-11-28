package net.soti.smartbattery.samsung.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import net.soti.smartbattery.R

@Composable
fun BatteryImagesCompose(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxHeight(0.25f)
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight(0.7F)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.ic_swirl_gradient),
            contentDescription = stringResource(id = R.string.swirl_gradient_image)
        )

        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxHeight(0.9F),
            painter = painterResource(id = R.drawable.battery_illustrator),
            contentDescription = stringResource(id = R.string.battery_illustrator_image)
        )
    }
}