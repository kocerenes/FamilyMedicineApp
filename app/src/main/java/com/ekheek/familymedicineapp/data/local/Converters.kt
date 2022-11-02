package com.ekheek.familymedicineapp.data.local

import androidx.room.TypeConverter
import com.ekheek.familymedicineapp.data.local.entities.AvailableAppointmentEntity
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun listToJson(value: List<AvailableAppointmentEntity>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<AvailableAppointmentEntity>::class.java).toList()
}