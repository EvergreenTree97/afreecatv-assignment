package com.sangrok.afreecatv.common

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun AfreecaText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Ellipsis,
) = BasicText(
    modifier = modifier,
    text = text,
    style = style,
    maxLines = maxLines,
    overflow = overflow,
)