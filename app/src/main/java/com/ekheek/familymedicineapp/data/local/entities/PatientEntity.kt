package com.ekheek.familymedicineapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "patients")
data class PatientEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String,
    @ColumnInfo(name = "weight")
    val weight: String,
    @ColumnInfo(name = "height")
    val height: String,
    @ColumnInfo(name = "age")
    val age: String
)