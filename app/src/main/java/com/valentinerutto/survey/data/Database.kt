
package com.valentinerutto.survey.data

import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.valentinerutto.survey.data.model.dao.SurveyDao
import com.valentinerutto.survey.data.model.local.Survey

@androidx.room.Database(
    entities = [
        Survey::class
    ],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class Database : RoomDatabase() {
    abstract fun surveyDao(): SurveyDao
}
