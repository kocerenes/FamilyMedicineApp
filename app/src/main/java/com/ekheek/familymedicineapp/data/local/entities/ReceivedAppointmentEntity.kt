package com.ekheek.familymedicineapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// alınabilir, açık randevu
@Entity(tableName = "received_appointments")
data class ReceivedAppointmentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "patientId")
    val patientId: Int,
    @ColumnInfo(name = "available_appointments")
    val availableAppointments: List<AvailableAppointmentEntity>,
    @ColumnInfo(name = "patientComplaints")
    val patientComplaints: String // hasta şikayeti
)
