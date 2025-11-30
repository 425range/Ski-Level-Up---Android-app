package com.example.skilevelup.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.skilevelup.data.dao.PracticeDao
import com.example.skilevelup.data.dao.SkillDao
import com.example.skilevelup.data.dao.UserDao
import com.example.skilevelup.data.entity.SkillEntity
import com.example.skilevelup.data.entity.PracticeEntity
import com.example.skilevelup.data.entity.UserEntity

@Database(
    entities = [SkillEntity::class, PracticeEntity::class, UserEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun skillDao(): SkillDao
    abstract fun practiceDao(): PracticeDao
    abstract fun userDao(): UserDao

    companion object {

        @Volatile private var INSTANCE: AppDatabase? = null

        fun get(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "skill_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
