package com.sangrok.domain.broad.model

data class Broad(
    val title: String,
    val id: String,
    val nickname: String,
    val profile: String,
    val grade: Grade,
    val totalViewCount: String,
)

enum class Grade(val number: String){
    Normal("0"),
    Adult("19")
}