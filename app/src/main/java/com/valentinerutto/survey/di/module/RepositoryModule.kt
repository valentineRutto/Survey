package com.valentinerutto.survey.di.module

import com.valentinerutto.survey.data.SurveyRepository

import org.koin.dsl.module

val repoModule = module {
    single {
        SurveyRepository(get(),get())
    }
}