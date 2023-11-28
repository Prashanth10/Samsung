package net.soti.smartbattery.samsung.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import net.soti.smartbattery.samsung.ui.viewModel.MainInfoViewModel

@Composable
fun MainComposeLayout(
    modifier: Modifier = Modifier,
    mainViewModel: MainInfoViewModel = viewModel()
) {
    val connState by mainViewModel.connStatus.collectAsState()
    val infoList by remember {
        derivedStateOf { mainViewModel.getInfoList() }
    }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        SotiTitleIconCompose()
        ConnectionStatusCompose(Modifier, connState)
        BatteryImagesCompose()
        SocketTitleCompose()
        InfoDetailsCompose(infoList, Modifier.align(Alignment.CenterHorizontally))
    }
}