package com.sangrok.afreecatv.main

import com.sangrok.domain.broad.model.Broad

sealed class MainSideEffect {
    data class NavigateToBroadDetail(
        val broad: Broad
    ) : MainSideEffect()
}