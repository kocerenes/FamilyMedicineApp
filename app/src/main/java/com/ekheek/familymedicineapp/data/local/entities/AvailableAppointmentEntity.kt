package com.ekheek.familymedicineapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "available_appointments")
data class AvailableAppointmentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "doctorName")
    val doctorName: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "time")
    val time: String,
    @ColumnInfo(name = "is_taken")
    val isTaken: Boolean = false // false by default
)