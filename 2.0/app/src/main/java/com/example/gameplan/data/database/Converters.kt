package com.example.gameplan.data.database

import androidx.room.TypeConverter
import com.example.gameplan.data.Genre
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromGenreList(genres: List<Genre?>?): String? {
        return gson.toJson(genres)
    }

    @TypeConverter
    fun toGenreList(data: String?): List<Genre?>? {
        if (data == null) return emptyList()
        val listType = object : TypeToken<List<Genre?>?>() {}.type
        return gson.fromJson(data, listType)
    }
}
