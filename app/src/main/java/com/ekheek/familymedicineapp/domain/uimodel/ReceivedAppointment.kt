package com.ekheek.familymedicineapp.domain.uimodel

data class ReceivedAppointment(
    val id: Int,
    val patientId: Int,
    val availableAppointments: List<AvailableAppointment>,
    val patientComplaints: String // hasta şikayeti
)
