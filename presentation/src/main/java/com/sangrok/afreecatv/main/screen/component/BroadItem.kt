package com.sangrok.afreecatv.main.screen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sangrok.afreecatv.theme.BodyMedium
import com.sangrok.afreecatv.theme.Caption2Regular
import com.sangrok.afreecatv.theme.Caption3Regular
import com.sangrok.afreecatv.theme.CaptionRegular
import com.sangrok.afreecatv.theme.HalfBlue
import com.sangrok.afreecatv.theme.Red
import com.sangrok.core.compose.AfreecaText
import com.sangrok.core.compose.AsyncCropImage
import com.sangrok.core.compose.DrawDot
import com.sangrok.core.compose.afreecaClickable
import com.sangrok.core.kotlin.toHttpsUrl
import com.sangrok.domain.broad.model.Broad
import com.sangrok.presentation.R

@Composable
internal fun BroadContent(
    item: Broad,
    onClickItem: (
        broad: Broad,
    ) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            )
            .afreecaClickable(
                onClick = {
                    onClickItem(item)
                }
            ),
        horizontalArrangement = Arrangement.spacedBy(space = 8.dp),
    ) {
        Thumbnail(
            modifier = Modifier
                .weight(1f),
            model = item.thumbnail.toHttpsUrl(),
        )
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(space = 8.dp)
        ) {
            AfreecaText(
                text = item.title,
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
                    model = item.profile.toHttpsUrl(),
                    contentDescription = "profile image"
                )
                Column {
                    AfreecaText(
                        text = item.nickname,
                        style = CaptionRegular.copy(color = HalfBlue)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(space = 2.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.person),
                            contentDescription = "view count"
                        )
                        AfreecaText(
                            text = item.totalViewCount,
                            style = Caption2Regular
                        )
                    }

                }
            }

        }
    }
}

@Composable
private fun Thumbnail(
    modifier: Modifier = Modifier,
    model: Any?,
) {
    Box(modifier = modifier) {
        AsyncCropImage(
            modifier = Modifier.clip(RoundedCornerShape(8.dp)),
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
