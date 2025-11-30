package com.example.skilevelup.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "practice")
data class PracticeEntity(
    @PrimaryKey val skillName: String,
    val done: Boolean
)
