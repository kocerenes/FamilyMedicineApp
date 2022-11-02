package com.ekheek.familymedicineapp.presentation.register

import android.view.View
import androidx.lifecycle.ViewModel
import com.ekheek.familymedicineapp.data.repository.RegisterRepository
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel: ViewModel() {

    private var repository: RegisterRepository = RegisterRepository()
    fun register(email: String,password: String, auth: FirebaseAuth,view: View){
        repository.register(email,password,auth,view)
    }
}