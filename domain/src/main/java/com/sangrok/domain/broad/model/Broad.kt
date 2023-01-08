package com.sangrok.domain.broad.model

import java.io.Serializable

data class Broad(
    val title: String,
    val id: String,
    val nickname: String,
    val thumbnail: String,
    val profile: String,
    val totalViewCount: String,
): Serializable