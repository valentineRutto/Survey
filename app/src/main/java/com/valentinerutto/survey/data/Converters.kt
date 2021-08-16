package com.valentinerutto.survey.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.valentinerutto.survey.data.model.local.Options

class Converters {

    @TypeConverter
    fun listToJson(value: List<Options>?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<Options>? {
        val objects =
            Gson().fromJson(value, Array<Options>::class.java) as Array<Options>
        val list = objects.toList()
        return list
    }
}