package com.ekheek.familymedicineapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ekheek.familymedicineapp.data.local.entities.PatientEntity

@Dao
interface FamilyMedicineDao {

    @Insert()
    suspend fun insertPatient(patientEntity: PatientEntity)

    @Query("SELECT * FROM patients WHERE id=:id")
    fun getPatientProfileInf(id: String): PatientEntity

}