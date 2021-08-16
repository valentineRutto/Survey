package com.valentinerutto.survey.di.module

import com.valentinerutto.survey.ui.SurveyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        SurveyViewModel(get())
    }
}
