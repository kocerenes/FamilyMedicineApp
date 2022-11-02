package com.ekheek.familymedicineapp.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekheek.familymedicineapp.data.local.entities.PatientEntity
import com.ekheek.familymedicineapp.data.repository.PatientRepository
import kotlinx.coroutines.launch

class ContinueRegisterViewModel(
    private val patientRepository: PatientRepository
) : ViewModel() {

    private fun insertPatient(patientEntity: PatientEntity) = viewModelScope.launch {
        patientRepository.insert(patientEntity)
    }

    // empty edit text check
    fun isEntryValid(
        firstName: String,
        lastName: String,
        phoneNumber: String,
        weight: Double,
        height: Double,
        age: Int
    ): Boolean {
        if (firstName.isBlank() || lastName.isBlank() || phoneNumber.isBlank() ||
            weight.toString().isBlank() || height.toString().isBlank() ||
            age.toString().isBlank()
        ) {
            return false
        }
        return true
    }

    private fun getNewPatientEntry(firstName: String,
                                   lastName: String,
                                   phoneNumber: String,
                                   weight: Double,
                                   height: Double,
                                   age: Int): PatientEntity  =
        PatientEntity(
            firstName = firstName,
            lastName = lastName,
            phoneNumber = phoneNumber,
            weight = weight,
            height = weight,
            age = age
        )


    fun addNewPatient(itemName: String, itemPrice: String, quantity: String) {
        val newItem = getNewItemEntry(itemName, itemPrice, quantity)
        insertItem(newItem)
    }
}