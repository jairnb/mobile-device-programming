package com.example.quizapplab7.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuestionDAO {

    @Insert
    suspend fun addQuestion(vararg quiz: Question)

    @Query("SELECT * FROM questions ORDER BY id")
    suspend fun findAllQuestions(): List<Question>

    @Query("DELETE FROM questions WHERE 1=1")
    suspend fun deleteAllQuestions()
}