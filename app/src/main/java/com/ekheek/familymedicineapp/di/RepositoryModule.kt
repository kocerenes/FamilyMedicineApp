package com.ekheek.familymedicineapp.di

import com.ekheek.familymedicineapp.data.local.dao.AppointmentDao
import com.ekheek.familymedicineapp.data.local.dao.PatientDao
import com.ekheek.familymedicineapp.data.repository.PatientRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePatientRepository(
        patientDao: PatientDao
    ): PatientRepository = PatientRepository(patientDao)

    @Provides
    @Singleton
    fun provideAppointmentRepository(
        appointmentDao: AppointmentDao
    ): AppointmentRepository = AppointmentRepository(appointmentDao)
}