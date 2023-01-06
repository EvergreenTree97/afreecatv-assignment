package com.sangrok.afreecatv.screen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sangrok.afreecatv.common.AfreecaText
import com.sangrok.afreecatv.common.DrawDot
import com.sangrok.afreecatv.common.afreecaClickable
import com.sangrok.afreecatv.theme.BodyMedium
import com.sangrok.afreecatv.theme.Caption2Regular
import com.sangrok.afreecatv.theme.Caption3Regular
import com.sangrok.afreecatv.theme.CaptionRegular
import com.sangrok.afreecatv.theme.HalfBlue
import com.sangrok.afreecatv.theme.Red
import com.sangrok.afreecatv.theme.Shapes
import com.sangrok.presentation.R

@Composable
internal fun BroadContent(
    thumbnail: String,
    title: String,
    profile: String,
    nickname: String,
    totalViewCount: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            )
            .afreecaClickable(onClick = onClick),
        horizontalArrangement = Arrangement.spacedBy(space = 8.dp),
    ) {
        Thumbnail(
            modifier = Modifier
                .height(height = 120.dp)
                .weight(1f)
                .clip(shape = Shapes.medium),
            model = thumbnail,
        )
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(space = 8.dp)
        ) {
            AfreecaText(
                text = title,
                style = BodyMedium,
                maxLines = 2,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(space = 4.dp)
            ) {
                AsyncCropImage(
                    modifier = Modifier
                        .size(size = 28.dp)
                        .clip(shape = CircleShape),
                    model = profile,
                    contentDescription = "profile image"
                )
                Column {
                    AfreecaText(
                        text = nickname,
                        style = CaptionRegular.copy(color = HalfBlue)
                    )
                    AfreecaText(
                        text = totalViewCount,
                        style = Caption2Regular
                    )
                }
            }

        }
    }
}

@Composable
internal fun AsyncCropImage(
    modifier: Modifier = Modifier,
    model: Any?,
    contentDescription: String,
) = AsyncImage(
    modifier = modifier,
    model = model,
    contentScale = ContentScale.Crop,
    contentDescription = contentDescription
)

@Composable
private fun Thumbnail(
    modifier: Modifier = Modifier,
    model: Any?,
) {
    Box(modifier = modifier) {
        AsyncCropImage(
            model = model,
            contentDescription = "thumbnail"
        )
        Row(
            modifier = Modifier.padding(all = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(space = 2.dp),
        ) {
            DrawDot(
                dotSize = 4.dp,
                color = Red
            )
            AfreecaText(
                text = stringResource(id = R.string.live),
                style = Caption3Regular.copy(color = Color.White)
            )
        }
    }
}