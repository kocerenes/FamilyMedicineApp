package com.ekheek.familymedicineapp.data.repository

import com.ekheek.familymedicineapp.data.local.FamilyMedicineDao
import com.ekheek.familymedicineapp.data.local.entities.PatientEntity
import javax.inject.Inject


class PatientProfileRepository @Inject constructor(
    private val familyMedicineDao: FamilyMedicineDao
) {

    fun getPatientProfileInf(id: String) = familyMedicineDao.getPatientProfileInf(id)
    suspend fun addPatient(patientEntity: PatientEntity) =
        familyMedicineDao.insertPatient(patientEntity)
}