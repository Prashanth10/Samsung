package net.soti.smartbattery.samsung.ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.soti.smartbattery.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SocketTitleCompose() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 18.dp)
    ) {
        Text(
            color = Color.White,
            text = stringResource(id = R.string.xt_socket),
            fontFamily = FontFamily(Font(R.font.gotham_rounded_book)),
            fontSize = dimensionResource(id = R.dimen.text_21sp).value.sp
        )
        Text(
            color = Color.White,
            text = stringResource(id = R.string.smart_battery_app),
            fontFamily = FontFamily(Font(R.font.source_sans_pro_light)),
            fontSize = dimensionResource(id = R.dimen.text_21sp).value.sp,
            modifier = Modifier.basicMarquee()
        )
    }
}