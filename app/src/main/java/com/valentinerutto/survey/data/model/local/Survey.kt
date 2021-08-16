package com.valentinerutto.survey.data.model.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.valentinerutto.survey.data.model.remote.SurveyResponse

@Entity
data class Survey(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val QuestionId: String?,
    val answerType: String?,
    val questionText: String?,
    val questionType: String?,
    val next: String?,
    val startingQuestionId: String?,
    val options: List<Options>
    )


data class Options(
    val displayText: String?,
    val value: String? )