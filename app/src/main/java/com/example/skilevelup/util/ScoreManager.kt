package com.example.skilevelup.util

import android.content.Context
import androidx.core.content.edit

class ScoreManager (context: Context) {

    private val prefs = context.getSharedPreferences("skill_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_TOTAL_SCORE = "total_score"
    }

    fun getTotalScore(): Int {
        return prefs.getInt(KEY_TOTAL_SCORE, 0)
    }

    fun addScore (scoreToAdd: Int) {
        val current = getTotalScore()
        prefs.edit {
            putInt(KEY_TOTAL_SCORE, current + scoreToAdd)
        }
    }

    fun resetScore(){
        prefs.edit {
            putInt(KEY_TOTAL_SCORE, 0)
        }
    }
}