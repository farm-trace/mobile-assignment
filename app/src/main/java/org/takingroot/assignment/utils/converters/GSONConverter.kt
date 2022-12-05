package org.takingroot.assignment.utils.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> Gson.fromJson(json: String) =
    fromJson<T>(json, object : TypeToken<T>() {}.type)

class GSONConverter {
    @TypeConverter
    fun fromMap(map: Map<String, Any>): String {
        return Gson().toJson(map)
    }

    @TypeConverter
    fun toMap(value: String): Map<String, Any> {
        return try {
            Gson().fromJson<Map<String, Any>>(value)
        } catch (e: Exception) {
            e.printStackTrace()
            emptyMap()
        }
    }
}