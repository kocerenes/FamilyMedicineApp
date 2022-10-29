package com.ekheek.familymedicineapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ekheek.familymedicineapp.data.local.dao.AppointmentDao
import com.ekheek.familymedicineapp.data.local.dao.PatientDao
import com.ekheek.familymedicineapp.data.local.entities.AppointmentEntity
import com.ekheek.familymedicineapp.data.local.entities.PatientEntity

@Database(
    entities = [PatientEntity::class, AppointmentEntity::class],
    version = 1,
    exportSchema = false // no need to export the database schema into a folder
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun patientDao(): PatientDao
    abstract fun appointmentDao(): AppointmentDao
}