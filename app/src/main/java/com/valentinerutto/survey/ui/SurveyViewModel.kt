package com.valentinerutto.survey.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valentinerutto.survey.data.SurveyRepository
import com.valentinerutto.survey.data.model.local.Survey
import kotlinx.coroutines.launch

class SurveyViewModel(private val surveyRepository: SurveyRepository) : ViewModel() {
     fun fetchSaveSurvey() =
        viewModelScope.launch {
            surveyRepository.fetchSaveSurvey()
        }

    suspend fun getSurvey(): List<Survey>{
        return surveyRepository.getSurvey()
    }



}