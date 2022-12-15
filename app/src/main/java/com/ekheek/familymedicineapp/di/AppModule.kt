package com.ekheek.familymedicineapp.di

import android.content.Context
import androidx.room.Room
import com.ekheek.familymedicineapp.data.local.AppDatabase
import com.ekheek.familymedicineapp.data.local.dao.AppointmentDao
import com.ekheek.familymedicineapp.data.local.dao.PatientDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideItemDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "family_doctor_db"
    ).build()

    @Singleton
    @Provides
    fun providePatientDao(
        db: AppDatabase
    ): PatientDao = db.patientDao()

    @Singleton
    @Provides
    fun provideAppointmentDao(
        db: AppDatabase
    ): AppointmentDao = db.appointmentDao()
}