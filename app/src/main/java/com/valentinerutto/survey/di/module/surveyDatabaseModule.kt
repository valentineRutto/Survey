package com.valentinerutto.survey.di.module

import androidx.room.Room
import com.valentinerutto.survey.data.Database
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val surveyDatabaseModule: Module = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            Database::class.java,
            "Survey"
        ).fallbackToDestructiveMigration().build()
    }
}