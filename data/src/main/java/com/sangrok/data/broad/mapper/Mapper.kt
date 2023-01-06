package com.sangrok.data.broad.mapper

import com.sangrok.data.broad.dto.response.BroadData
import com.sangrok.data.broad.dto.response.CategoryData
import com.sangrok.data.broad.dto.response.CategoryResponse
import com.sangrok.domain.broad.model.Broad
import com.sangrok.domain.broad.model.Category
import com.sangrok.domain.broad.model.Grade

internal fun CategoryResponse.toDomain() = this.broadCategories.map { it.toDomain() }

internal fun CategoryData.toDomain() = Category(
    name = name,
    id = number,
)

internal fun BroadData.toDomain() = Broad(
    title = title,
    id = number,
    nickname = userNickname,
    profile = profileImage,
    grade = when (grade) {
        "19" -> Grade.Adult
        else -> Grade.Normal
    },
    totalViewCount = totalViewCount,
)