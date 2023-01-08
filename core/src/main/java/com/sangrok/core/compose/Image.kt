package com.sangrok.core.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun AsyncCropImage(
    modifier: Modifier = Modifier,
    model: Any?,
    contentDescription: String,
) {
    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current)
            .data(model)
            .build(),
        contentScale = ContentScale.Crop,
        contentDescription = contentDescription
    )
}
