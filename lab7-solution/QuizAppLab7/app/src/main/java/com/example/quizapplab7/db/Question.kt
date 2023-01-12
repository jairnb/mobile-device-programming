package com.example.quizapplab7.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "questions")
data class Question (
    @PrimaryKey
    val id: Int,
    val question: String?,
    val op1: String?,
    val op2: String?,
    val op3: String?,
    val op4: String?,
    val correctOption: String?,
    val answer: String?,
): Serializable