package com.valentinerutto.survey.network

import com.valentinerutto.survey.data.model.remote.SurveyResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("d628facc-ec18-431d-a8fc-9c096e00709a")
    suspend fun fetchSurvey(): Response<SurveyResponse>

}