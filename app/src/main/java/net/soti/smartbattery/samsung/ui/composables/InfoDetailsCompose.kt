package net.soti.smartbattery.samsung.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.soti.smartbattery.samsung.ui.model.Info

@Composable
fun InfoDetailsCompose(
    infoList: List<Info>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(0.84f)
            .padding(top = 16.dp, bottom = 16.dp),
    ) {
        items(infoList) { it ->
            InfoCompose(it)
        }
    }
}