package com.ekheek.familymedicineapp.data.repository

import com.ekheek.familymedicineapp.data.local.dao.PatientDao
import com.ekheek.familymedicineapp.data.local.entities.PatientEntity

class PatientRepository(
    private val patientDao: PatientDao
) {
    suspend fun insert(patient: PatientEntity) = patientDao.insert(patient)
    fun getById(id: Int) = patientDao.getById(id)
}