package com.sangrok.afreecatv.detail.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.sangrok.afreecatv.main.screen.component.MainTopBar
import com.sangrok.afreecatv.theme.HeadLineSemiBold
import com.sangrok.core.compose.AfreecaText
import com.sangrok.core.compose.AsyncCropImage
import com.sangrok.core.kotlin.toHttpsUrl
import com.sangrok.domain.broad.model.Broad

@Composable
internal fun DetailScreen(broad: Broad) {
    Scaffold(
        topBar = {
            MainTopBar(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
            )
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AfreecaText(
                text = broad.title,
                style = HeadLineSemiBold
            )
            AsyncCropImage(
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                model = broad.thumbnail.toHttpsUrl(),
                contentDescription = "thumbnail"
            )
            AfreecaText(
                text = broad.nickname,
                style = HeadLineSemiBold
            )
            AsyncCropImage(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                model = broad.profile.toHttpsUrl(),
                contentDescription = "profile"
            )
        }
    }
}