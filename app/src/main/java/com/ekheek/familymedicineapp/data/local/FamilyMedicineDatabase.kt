package com.ekheek.familymedicineapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ekheek.familymedicineapp.data.local.entities.PatientEntity

private const val DB_NAME = "family_medicine_database"

@Database(entities = [(PatientEntity::class)], version = 1)
abstract class FamilyMedicineDatabase : RoomDatabase() {

    abstract fun familyMedicineDao(): FamilyMedicineDao

    companion object {
        fun create(context: Context): FamilyMedicineDatabase {
            return Room.databaseBuilder(
                context,
                FamilyMedicineDatabase::class.java,
                DB_NAME
            ).build()
        }
    }
}