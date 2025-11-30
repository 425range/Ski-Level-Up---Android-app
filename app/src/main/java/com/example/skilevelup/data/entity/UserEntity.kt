package com.example.skilevelup.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val uid: Int = 0,
    val totalScore: Int
)
