package com.valentinerutto

import android.app.Application
import com.valentinerutto.survey.di.module.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:  Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(koinModules )
        }
    }

    companion object {
        open val context = koinModules
    }
}