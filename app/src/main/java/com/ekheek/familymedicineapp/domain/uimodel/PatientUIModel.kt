package com.ekheek.familymedicineapp.domain.uimodel

data class PatientUIModel(
    val id: Int,
    val mail: String?,
    val password: String?,
    val name: String,
    val phone: String,
    val weight: Double,
    val height: Double,
    val age: Int
)
