package com.ekheek.familymedicineapp.presentation.register

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import com.ekheek.familymedicineapp.data.local.entities.PatientEntity
import com.ekheek.familymedicineapp.data.repository.PatientProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContinueRegisterViewModel @Inject constructor(
    private val repository: PatientProfileRepository
):ViewModel() {
    fun addPatient(patientEntity: PatientEntity,view:View) = viewModelScope.launch {
        repository.addPatient(patientEntity)
        val action = ContinueRegisterFragmentDirections.actionContinueRegisterFragmentToProfileFragment(patientEntity.id)
        Navigation.findNavController(view).navigate(action)
    }
}