package com.example.skilevelup.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.skilevelup.data.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT totalScore FROM user WHERE uid = 0")
    suspend fun getScore(): Int?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: UserEntity)
}
