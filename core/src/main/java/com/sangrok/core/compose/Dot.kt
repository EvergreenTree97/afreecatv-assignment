package com.sangrok.core.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun DrawDot(
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
