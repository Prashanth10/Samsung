package net.soti.smartbattery.samsung.ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.soti.smartbattery.R
import net.soti.smartbattery.samsung.ui.model.Info

@Composable
fun InfoCompose(
    info: Info,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(top = 16.dp, bottom = 16.dp)
    ) {
        DisplayIcon(info)
        DisplayTitleAndContent(info)
    }
}

@Composable
fun DisplayIcon(info: Info, modifier: Modifier = Modifier) {
    Image(
        contentDescription = null,
        modifier = modifier.size(36.dp),
        painter = painterResource(id = info.drawable),
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DisplayTitleAndContent(info: Info, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(start = 16.dp)
    ) {
        val localContext = LocalContext.current
        val coroutineScope = rememberCoroutineScope()
        var clickCount by remember { mutableIntStateOf(0) }
        var timerState by remember { mutableStateOf(false) }

        Text(maxLines = 1,
            text = info.title,
            color = colorResource(R.color.white_smoke),
            fontSize = dimensionResource(id = R.dimen.text_13sp).value.sp,
            fontFamily = FontFamily(Font(R.font.source_sans_pro_semi_bold)),
            modifier = Modifier
                .basicMarquee()
                .clickable {
                    if (!timerState) {
                        timerState = true
                        coroutineScope.launch {
                            delay(5000)
                            clickCount = 0
                            timerState = false
                        }
                    }
                    clickCount++
                    if (clickCount >= 5) {
                        clickCount = 0
                        timerState = false
//                        startActivity(info.title, localContext) //Start Activity
                    }
                })
        DisplayContent(info.contents)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DisplayContent(contents: List<String>, modifier: Modifier = Modifier) {
    for (content in contents) {
        Text(
            maxLines = 1,
            text = content,
            modifier = Modifier
                .padding(top = 2.dp)
                .basicMarquee(),
            color = colorResource(R.color.gray),
            fontFamily = FontFamily(Font(R.font.source_sans_pro_regular)),
            fontSize = dimensionResource(id = R.dimen.text_13sp).value.sp
        )
    }
}

/*
fun startActivity(title: String, localContext: Context) {
    if (title == SamsungApplication.instance.resources.getString(R.string.battery_info)) {
        val intent = Intent(localContext, BatteryInfoActivity::class.java)
        localContext.startActivity(intent)
    } else if (title == ZebraApplication.instance.getString(R.string.socket_version_title)) {
        val intent = Intent(localContext, LogConfigActivity::class.java)
        localContext.startActivity(intent)
    }
}*/
