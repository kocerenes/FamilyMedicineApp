package com.ekheek.familymedicineapp.domain.uimodel

data class AvailableAppointment(
    val id: Int,
    val doctorName: String,
    val date: String,
    val time: String,
    val isTaken: Boolean = false
)
