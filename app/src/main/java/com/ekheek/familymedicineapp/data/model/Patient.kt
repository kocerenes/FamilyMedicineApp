package com.ekheek.familymedicineapp.data.model

data class Patient(
    val id: String?,
    val mail: String?,
    val password: String?,
    val name: String?,
    val phone: String?,
    val weight: Double?,
    val height: Double?,
    val dateOfBirth: String?,
    val age: Int?
)