package com.ekheek.familymedicineapp.domain.uimodel

data class Patient(
    val id: String,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val weight: Double,
    val height: Double,
    val age: Int
)
