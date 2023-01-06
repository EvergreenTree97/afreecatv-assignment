package com.sangrok.afreecatv.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
internal fun DrawDot(
    dotSize: Dp,
    color: Color
) {
    Canvas(modifier = Modifier.size(dotSize),
        onDraw = {
            val size = dotSize.toPx()
            drawCircle(
                color = color,
                radius = size / 2f
            )
        }
    )
}
