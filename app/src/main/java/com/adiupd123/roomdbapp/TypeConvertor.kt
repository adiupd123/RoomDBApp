package com.adiupd123.roomdbapp

import androidx.room.TypeConverter
import java.util.*

class TypeConvertor {
    @TypeConverter
    fun convertDateToLong(date: Date): Long {
        return date.time
    }
    @TypeConverter
    fun convertLongToDate(time: Long): Date{
        return Date(time)
    }
}