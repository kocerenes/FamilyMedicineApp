package com.ekheek.familymedicineapp.data.local.relationships

import androidx.room.Embedded
import androidx.room.Relation
import com.ekheek.familymedicineapp.data.local.entities.AppointmentEntity
import com.ekheek.familymedicineapp.data.local.entities.PatientEntity

data class PatientWithAppointments(
    @Embedded val patientEntity: PatientEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "patientId",
    )
    val appointments: List<AppointmentEntity>
)