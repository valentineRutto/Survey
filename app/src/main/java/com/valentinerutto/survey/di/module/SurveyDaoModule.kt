package com.valentinerutto.survey.di.module

import com.valentinerutto.survey.data.Database
import org.koin.core.module.Module
import org.koin.dsl.module

val surveyDaoModule: Module = module {
    single { get<Database>().surveyDao() }
}
