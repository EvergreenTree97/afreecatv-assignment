package com.sangrok.data.broad.dto.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("broad_category")
    val broadCategories: List<CategoryData>
)

data class CategoryData(
    @SerializedName("cate_name")
    val name: String,
    @SerializedName("cate_no")
    val number: String,
    @SerializedName("child")
    val child: List<ChildCategoryData>
)

data class ChildCategoryData(
    @SerializedName("cate_name")
    val name: String,
    @SerializedName("cate_no")
    val number: String
)