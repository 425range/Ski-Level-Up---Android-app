package com.example.skilevelup.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.skilevelup.data.entity.PracticeEntity

@Dao
interface PracticeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setDone(practice: PracticeEntity)

    @Query("UPDATE practice SET done = 0")
    suspend fun resetAllPractice()

    @Query("SELECT done FROM practice WHERE skillName = :name")
    suspend fun isDone(name: String): Boolean?

}
