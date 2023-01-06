package com.sangrok.afreecatv.screen.component

import androidx.compose.material.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sangrok.afreecatv.theme.MainBlue

@Composable
internal fun AfreecaTabBar(
    selectedTabIndex: Int,
    tabs: @Composable () -> Unit
) = ScrollableTabRow(
    selectedTabIndex = selectedTabIndex,
    backgroundColor = Color.White,
    contentColor = MainBlue,
    edgePadding = 0.dp,
    tabs = tabs
)