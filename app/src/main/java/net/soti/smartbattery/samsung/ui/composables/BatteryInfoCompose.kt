package net.soti.smartbattery.samsung.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import net.soti.smartbattery.R
import net.soti.smartbattery.samsung.models.RawData
import net.soti.smartbattery.samsung.ui.theme.DarkActionBar
import net.soti.smartbattery.samsung.ui.theme.Gray
import net.soti.smartbattery.samsung.ui.viewModel.BatteryInfoViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun BatteryInfoCompose() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.battery_info), color = Color.White) },
                colors = TopAppBarDefaults.smallTopAppBarColors(DarkActionBar)
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = MaterialTheme.colorScheme.background
        ) {
            val batteryInfoViewModel = viewModel<BatteryInfoViewModel>()
            val isLoading by batteryInfoViewModel.isLoading.collectAsState()
            val pullRefreshState = rememberPullRefreshState(
                refreshing = isLoading,
                onRefresh = { batteryInfoViewModel.loadBatteryData() }
            )
            Box(modifier = Modifier.pullRefresh(pullRefreshState)) {
                BatteryInfoList(batteryInfoViewModel.batteryInfoList.value)
                PullRefreshIndicator(
                    refreshing = isLoading,
                    state = pullRefreshState,
                    Modifier.align(Alignment.TopCenter)
                )
            }
        }
    }
}

@Composable
fun BatteryInfoList(batteryInfoList: List<RawData>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(vertical = 10.dp)
    ) {
        items(batteryInfoList) {
            Text(
                text = it.title,
                color = Color.White,
                fontSize = dimensionResource(id = R.dimen.text_16sp).value.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
            Text(
                text = it.value,
                color = Gray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 20.dp),
                fontSize = dimensionResource(id = R.dimen.text_16sp).value.sp
            )
            Divider(modifier = Modifier.padding(vertical = 10.dp), color = Color.DarkGray)
        }
    }
}