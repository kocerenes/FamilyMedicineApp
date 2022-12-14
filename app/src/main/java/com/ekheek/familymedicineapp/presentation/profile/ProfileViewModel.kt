package com.ekheek.familymedicineapp.presentation.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekheek.familymedicineapp.data.local.entities.PatientEntity
import com.ekheek.familymedicineapp.data.repository.PatientProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: PatientProfileRepository
) : ViewModel() {
    var patient: MutableLiveData<PatientEntity> = MutableLiveData()

    fun getData(
        id: String
    ) = viewModelScope.launch(Dispatchers.IO) {
        patient.postValue(repository.getPatientProfileInf(id))
    }
}