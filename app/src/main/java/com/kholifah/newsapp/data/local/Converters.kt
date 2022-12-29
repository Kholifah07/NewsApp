package com.kholifah.newsapp.data.local

import androidx.room.TypeConverter
import com.kholifah.newsapp.data.model.Source
// digunakan untuk mengonversi data
class Converters {

    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name, name)
    }
}