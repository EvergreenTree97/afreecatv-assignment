@file:OptIn(ExperimentalPagerApi::class)

package com.sangrok.afreecatv.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.sangrok.afreecatv.MainViewModel
import com.sangrok.afreecatv.screen.Dummy.BroadContentDummy
import com.sangrok.afreecatv.screen.Dummy.tabData
import com.sangrok.afreecatv.screen.component.BroadContent
import com.sangrok.afreecatv.screen.component.TopBar
import com.sangrok.afreecatv.theme.MainBlue
import kotlinx.coroutines.launch


@Composable
internal fun MainScreen(
    viewModel: MainViewModel
) {
    var tabIndex by remember { mutableStateOf(0) }
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopBar(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
            )
        },
    ) {
        Column {
            ScrollableTabRow(
                selectedTabIndex = tabIndex,
                backgroundColor = Color.White,
                contentColor = MainBlue,
                edgePadding = 0.dp,
            ) {
                tabData.forEachIndexed { index, text ->
                    Tab(
                        modifier = Modifier.background(Color.White),
                        selected = tabIndex == index,
                        onClick = {
                            tabIndex = index
                            coroutineScope.launch { pagerState.animateScrollToPage(index) }
                        },
                        text = {
                            Text(text = text)
                        }
                    )
                }
            }
            HorizontalPager(
                count = tabData.size,
                state = pagerState,
                itemSpacing = 8.dp,
                key = { it },
            ) {
                LazyColumn {
                    items(
                        items = BroadContentDummy,
                        key = { it.nickname },
                    ) {
                        BroadContent(
                            thumbnail = it.thumbnail,
                            title = it.title,
                            profile = it.profile,
                            nickname = it.nickname,
                            totalViewCount = it.totalViewCount
                        )
                    }
                }
            }
        }
    }
}

object Dummy {
    val tabData = listOf(
        "프로필", "쪽지", "보이는 라디오", "CC", "먹방/쿡방"
    )

    val BroadContentDummy = (0..10).map {
        Broad(nickname = "에버그린록+$it")
    }
}

data class Broad(
    val nickname: String = "에버그린록",
    val thumbnail: String = "https://cdn.pixabay.com/photo/2022/12/30/11/09/cat-7686662_960_720.jpg",
    val title: String = "롤 1500++ 골드 방송",
    val profile: String = "https://cdn.pixabay.com/photo/2022/12/30/11/09/cat-7686662_960_720.jpg",
    val totalViewCount: Int = 300,
)