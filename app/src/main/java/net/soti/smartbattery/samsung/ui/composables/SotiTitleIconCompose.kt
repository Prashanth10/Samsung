package net.soti.smartbattery.samsung.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import net.soti.smartbattery.R

@Composable
fun SotiTitleIconCompose(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(top = 55.dp, end = 55.dp)
            .widthIn(302.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Image(
            modifier = Modifier
                .width(40.dp)
                .height(10.dp),
            painter = painterResource(id = R.drawable.ic_soti_white),
            contentDescription = stringResource(id = R.string.soti_icon)
        )
    }
}