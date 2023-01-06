package com.sangrok.data.broad.dto.response

import com.google.gson.annotations.SerializedName

data class BroadResponse(
    @SerializedName("broad")
    val broads: List<BroadData>,
    @SerializedName("page_block")
    val pageBlock: Int,
    @SerializedName("page_no")
    val pageNumber: Int,
    @SerializedName("time")
    val time: Int,
    @SerializedName("total_cnt")
    val totalCount: Int
)

data class BroadData(
    @SerializedName("broad_bps")
    val bps: String,
    @SerializedName("broad_cate_no")
    val categoryNumber: String,
    @SerializedName("broad_grade")
    val grade: String,
    @SerializedName("broad_no")
    val number: String,
    @SerializedName("broad_resolution")
    val resolution: String,
    @SerializedName("broad_start")
    val startTime: String,
    @SerializedName("broad_thumb")
    val thumbnail: String,
    @SerializedName("broad_title")
    val title: String,
    @SerializedName("is_password")
    val isPassword: String,
    @SerializedName("profile_img")
    val profileImage: String,
    @SerializedName("total_view_cnt")
    val totalViewCount: String,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("user_nick")
    val userNickname: String,
    @SerializedName("visit_broad_type")
    val visitBroadType: String
)