package net.soti.smartbattery.samsung.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.soti.smartbattery.R
import net.soti.smartbattery.samsung.ui.theme.Lime
import net.soti.smartbattery.samsung.ui.theme.Red

@Composable
fun ConnectionStatusCompose(
    modifier: Modifier = Modifier, connStatus: Boolean = false
) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(
                id = if (connStatus) R.drawable.ic_device_connected else R.drawable.ic_device_disconnected
            ),
            modifier = Modifier.size(40.dp, 40.dp),
            contentDescription = stringResource(id = R.string.connection_status_icon)
        )
        Text(
            modifier = Modifier
                .padding(start = 6.dp)
                .align(Alignment.CenterVertically),
            color = if (connStatus) Lime else Red,
            fontSize = dimensionResource(id = R.dimen.text_16sp).value.sp,
            fontFamily = FontFamily(Font(R.font.source_sans_pro_semi_bold)),
            text = stringResource(id = if (connStatus) R.string.connected else R.string.disconnected),
        )
    }
}