package com.ekheek.familymedicineapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ekheek.familymedicineapp.data.local.dao.AppointmentDao
import com.ekheek.familymedicineapp.data.local.dao.PatientDao
import com.ekheek.familymedicineapp.data.local.entities.AvailableAppointmentEntity
import com.ekheek.familymedicineapp.data.local.entities.PatientEntity
import com.ekheek.familymedicineapp.data.local.entities.ReceivedAppointmentEntity

@Database(
    entities = [
        PatientEntity::class,
        AvailableAppointmentEntity::class,
        ReceivedAppointmentEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun patientDao(): PatientDao
    abstract fun appointmentDao(): AppointmentDao
}