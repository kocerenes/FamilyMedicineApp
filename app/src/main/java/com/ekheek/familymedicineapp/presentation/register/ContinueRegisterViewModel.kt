package com.ekheek.familymedicineapp.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekheek.familymedicineapp.data.local.entities.PatientEntity
import com.ekheek.familymedicineapp.data.repository.PatientProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContinueRegisterViewModel @Inject constructor(
    private val repository: PatientProfileRepository
) : ViewModel() {
    fun addPatient(patientEntity: PatientEntity) =
        viewModelScope.launch { repository.addPatient(patientEntity) }
}