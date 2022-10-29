package com.ekheek.familymedicineapp.data.local.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appointments")
data class AppointmentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "patientId")
    val patientId: Int,
    @ColumnInfo(name = "doctorName")
    val doctorName: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "time")
    val time: String,
    @ColumnInfo(name = "patientComplaints")
    val patientComplaints: String // hasta şikayeti
)