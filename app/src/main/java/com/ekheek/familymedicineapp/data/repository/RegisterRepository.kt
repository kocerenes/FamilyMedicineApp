package com.ekheek.familymedicineapp.data.repository


import android.view.View
import androidx.navigation.Navigation
import com.ekheek.familymedicineapp.presentation.register.RegisterFragmentDirections
import com.google.firebase.auth.FirebaseAuth

class RegisterRepository() {


    fun register(email: String, password: String, auth: FirebaseAuth, view: View) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    val action =
                        RegisterFragmentDirections.actionRegisterFragmentToContinueRegisterFragment()
                    Navigation.findNavController(view).navigate(action)
                }
            }
    }
}