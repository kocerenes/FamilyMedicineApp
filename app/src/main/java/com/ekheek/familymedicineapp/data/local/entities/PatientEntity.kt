package com.ekheek.familymedicineapp.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "patients")
data class PatientEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "mail")
    val mail: String?,
    @ColumnInfo(name = "password")
    val password: String?,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "weight")
    val weight: Double,
    @ColumnInfo(name = "height")
    val height: Double,
    @ColumnInfo(name = "age")
    val age: Int
)