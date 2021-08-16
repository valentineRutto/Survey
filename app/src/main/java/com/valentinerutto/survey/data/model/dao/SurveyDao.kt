package com.valentinerutto.survey.data.model.dao

import androidx.room.Dao
import androidx.room.Query
import com.valentinerutto.survey.data.model.local.Survey

@Dao
interface SurveyDao: BaseDao<Survey> {

    @Query("SELECT * FROM Survey")
    suspend fun getSurveyQuestions(): List<Survey>

}