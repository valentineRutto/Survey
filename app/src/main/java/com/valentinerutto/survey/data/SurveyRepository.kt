package com.valentinerutto.survey.data

import com.valentinerutto.survey.data.model.dao.SurveyDao
import com.valentinerutto.survey.data.model.local.Options
import com.valentinerutto.survey.data.model.local.Survey
import com.valentinerutto.survey.data.model.remote.SurveyResponse
import com.valentinerutto.survey.network.ApiService
import com.valentinerutto.survey.network.Resource
import retrofit2.Response

class SurveyRepository(private val apiService: ApiService, private val surveyDao: SurveyDao) {


    suspend fun getSurvey(): List<Survey> {
        return surveyDao.getSurveyQuestions(
        )
    }

    suspend fun fetchSaveSurvey() {
        val survey = fetchSurvey()
        if (survey != null) {
            surveyDao.insert(survey)
        }
    }
    suspend fun fetchSurvey(): List<Survey>?{
        val response = apiService.fetchSurvey( )
        val startingQuestionId = response.body()?.startQuestionId
                return response.body()?.questions?.map{

                    Survey(
                        next = it?.next,
                        questionText = it?.questionText,
                        questionType = it?.questionType,
                        answerType = it?.answerType,
                        startingQuestionId = startingQuestionId,
                        id = 2,
                        QuestionId = it?.id,
                        options = emptyList()
                    )

        }

    }

}