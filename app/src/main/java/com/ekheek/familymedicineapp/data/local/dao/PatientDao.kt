package com.ekheek.familymedicineapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ekheek.familymedicineapp.data.local.entities.PatientEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PatientDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(patient: PatientEntity)

    @Query("SELECT * FROM patients WHERE id = :id ")
    fun getById(id: Int): Flow<PatientEntity>
}