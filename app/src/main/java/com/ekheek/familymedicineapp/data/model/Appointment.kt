package com.ekheek.familymedicineapp.data.model

import com.google.firebase.Timestamp

data class Appointment(
    val id: String?,
    val patientId: String?,
    val doctorName: String?,
    val date: Timestamp?,
    val time: String?,
    val patientComplaints: String? // hasta şikayeti
)