package com.sangrok.afreecatv.main.screen.component

import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.TabPosition
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sangrok.afreecatv.theme.MainBlue

@Composable
internal fun MainTabBar(
    selectedTabIndex: Int,
    indicator: @Composable (List<TabPosition>) -> Unit,
    tabs: @Composable () -> Unit
) = ScrollableTabRow(
    selectedTabIndex = selectedTabIndex,
    backgroundColor = Color.White,
    contentColor = MainBlue,
    indicator = indicator,
    edgePadding = 0.dp,
    tabs = tabs
)