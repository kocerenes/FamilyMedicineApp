package com.ekheek.familymedicineapp.domain.uimodel

data class AppointmentUIModel(
    val id: String,
    val patientId: Int,
    val doctorName: String,
    val date: String,
    val time: String,
    val patientComplaints: String // hasta şikayeti
)
