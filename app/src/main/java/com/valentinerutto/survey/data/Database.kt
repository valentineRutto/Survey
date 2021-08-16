
package com.valentinerutto.survey.data

import androidx.room.RoomDatabase
import com.valentinerutto.survey.data.model.dao.SurveyDao
import com.valentinerutto.survey.data.model.local.Survey

@androidx.room.Database(
    entities = [
        Survey::class
    ],
    version = 1,
    exportSchema = false
)

abstract class Database : RoomDatabase() {
    abstract fun surveyDao(): SurveyDao
}
