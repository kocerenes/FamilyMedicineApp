package com.ekheek.familymedicineapp.domain.mapper

import com.ekheek.familymedicineapp.data.local.entities.PatientEntity
import com.ekheek.familymedicineapp.domain.uimodel.Patient

fun PatientEntity.toDomainModel() = Patient(
    id = id,
    firstName = firstName,
    lastName = lastName,
    phoneNumber = phoneNumber,
    weight = weight,
    height = height,
    age = age
)