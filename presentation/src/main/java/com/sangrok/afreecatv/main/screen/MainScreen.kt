@file:OptIn(ExperimentalPagerApi::class)

package com.sangrok.afreecatv.main.screen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.sangrok.afreecatv.detail.DetailActivity
import com.sangrok.afreecatv.main.MainSideEffect
import com.sangrok.afreecatv.main.MainViewModel
import com.sangrok.afreecatv.main.screen.component.BroadContent
import com.sangrok.afreecatv.main.screen.component.MainTabBar
import com.sangrok.afreecatv.main.screen.component.MainTopBar
import com.sangrok.afreecatv.theme.HeadLineRegular
import com.sangrok.afreecatv.theme.HeadLineSemiBold
import com.sangrok.afreecatv.theme.MainBlue
import com.sangrok.core.android.startActivityWithAnimation
import com.sangrok.core.compose.AfreecaText
import com.sangrok.core.compose.FadeAnimatedVisibility
import com.sangrok.core.compose.LoadingIndicator
import com.sangrok.core.compose.collectAsStateWithLifecycle
import com.sangrok.domain.broad.model.Broad
import com.sangrok.domain.broad.model.Category
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.launch

internal const val InitialTabIndex = 0

@Composable
internal fun MainScreen(
    viewModel: MainViewModel,
) {
    val activity = LocalContext.current as Activity
    val state by viewModel.state.collectAsStateWithLifecycle()
    val broads by rememberUpdatedState(newValue = state.broads.collectAsLazyPagingItems())

    LaunchedEffect(Unit) {
        viewModel.getCategories()
    }

    LaunchedEffect(key1 = viewModel.sideEffect) {
        viewModel.sideEffect.collect {
            when (it) {
                is MainSideEffect.NavigateToBroadDetail -> {
                    activity.startActivityWithAnimation<DetailActivity>(
                        withFinish = false,
                        intentBuilder = {
                            val bundle = Bundle().apply {
                                putSerializable("broad", it.broad)
                            }
                            putExtra("bundle", bundle)
                        }
                    )
                }
            }
        }
    }

    FadeAnimatedVisibility(
        visible = state.isCategoryLoading.not(),
    ) {
        Scaffold(
            topBar = {
                MainTopBar(
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                )
            },
        ) {
            MainContent(
                broads = broads,
                isBroadLoading = state.isBroadLoading,
                categories = state.categories,
                onClickTab = viewModel::onTabSelected,
                onClickBroad = viewModel::onClickBroad,
            )
        }
    }

}

@Composable
private fun MainContent(
    broads: LazyPagingItems<Broad>,
    isBroadLoading: Boolean,
    categories: ImmutableList<Category>,
    onClickTab: (index: Int) -> Unit,
    onClickBroad: (broad: Broad) -> Unit,
) {
    val pagerState = rememberPagerState(InitialTabIndex)
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }
            .collect { page ->
                onClickTab(page)
            }
    }

    Column {
        MainTabBar(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                )
            }
        ) {
            categories.forEachIndexed { index, item ->
                Tab(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .background(Color.White),
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch { pagerState.scrollToPage(index) }
                    },
                    text = {
                        AfreecaText(
                            text = item.name,
                            style = if (pagerState.currentPage == index) {
                                HeadLineSemiBold.copy(color = MainBlue)
                            } else {
                                HeadLineRegular
                            }
                        )
                    }
                )
            }
        }
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            count = categories.size,
            state = pagerState,
            itemSpacing = 8.dp,
        ) {
            FadeAnimatedVisibility(visible = isBroadLoading.not()) {
                LazyColumn {
                    items(
                        items = broads,
                        key = { it }
                    ) { item ->
                        item?.run {
                            BroadContent(
                                item = item,
                                onClickItem = onClickBroad
                            )
                        }
                    }
                    when (broads.loadState.append) {
                        LoadState.Loading -> {
                            item {
                                LoadingIndicator(
                                    modifier = Modifier.fillMaxWidth(),
                                    color = MainBlue,
                                )
                            }
                        }
                        else -> {}
                    }
                }
            }

        }
    }
}
