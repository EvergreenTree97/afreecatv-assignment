package com.sangrok.afreecatv.screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
internal fun BroadContent(
    thumbnail: String,
    title: String,
    profile: String,
    nickname: String,
    totalViewCount: Int,
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        AsyncCropImage(
            model = thumbnail,
            contentDescription = "thumbnail"
        )
        Column {
            Text(text = title)
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncCropImage(
                    model = profile,
                    contentDescription = "profile image"
                )
                Column {
                    Text(text = nickname)
                    Text(text = totalViewCount.toString())
                }
            }

        }
    }
}

@Composable
private fun AsyncCropImage(
    modifier: Modifier = Modifier,
    model: Any?,
    contentDescription: String,
) = AsyncImage(
    modifier = modifier,
    model = model,
    contentScale = ContentScale.Crop,
    contentDescription = contentDescription
)