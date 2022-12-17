package com.ekheek.familymedicineapp.data.local.entities

import com.google.firebase.Timestamp

data class Appointment(
    val date: Timestamp,
    val medicineName: String,
    val doctorName: String,
    val medicineAddress: String
)