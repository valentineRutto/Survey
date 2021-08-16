package com.valentinerutto

import android.app.Application
import com.valentinerutto.survey.di.module.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:  Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, repoModule, viewModelModule, surveyDaoModule, surveyDatabaseModule))
        }
    }

    companion object {
        open val context = appModule

    }
}