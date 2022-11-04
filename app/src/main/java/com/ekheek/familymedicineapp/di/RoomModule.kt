package com.ekheek.familymedicineapp.di

import android.content.Context
import com.ekheek.familymedicineapp.data.local.FamilyMedicineDao
import com.ekheek.familymedicineapp.data.local.FamilyMedicineDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): FamilyMedicineDatabase =
        FamilyMedicineDatabase.create(context)

    @Provides
    fun provideDao(database: FamilyMedicineDatabase): FamilyMedicineDao {
        return database.familyMedicineDao()
    }
}