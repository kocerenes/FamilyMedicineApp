package com.ekheek.familymedicineapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.ekheek.familymedicineapp.data.local.entities.PatientEntity
import com.ekheek.familymedicineapp.data.local.relationships.PatientWithAppointments

@Dao
interface PatientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(patient: PatientEntity)

    @Transaction
    @Query("SELECT * FROM patients WHERE id = :id")
    suspend fun getPatientWithAppointments(id: Int): List<PatientWithAppointments>
}