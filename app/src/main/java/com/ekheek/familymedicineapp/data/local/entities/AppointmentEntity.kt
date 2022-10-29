package com.ekheek.familymedicineapp.data.local.entities

import androidx.room.Entity

@Entity(tableName = "appointments")
data class AppointmentEntity(
    val id: String,
    val patientId: Int,
    val doctorName: String,
    val date: String,
    val time: String,
    val patientComplaints: String // hasta şikayeti
)