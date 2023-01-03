package com.ekheek.familymedicineapp.presentation.register

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.ekheek.familymedicineapp.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    fun register(
        email: String,
        password: String,
        auth: FirebaseAuth,
        view: View,
        binding: FragmentRegisterBinding
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    val action =
                        RegisterFragmentDirections.actionRegisterFragmentToContinueRegisterFragment(auth.uid!!)
                    Navigation.findNavController(view).navigate(action)
                } else {
                    binding.progressBar.visibility = View.GONE
                    binding.linearLayout.visibility = View.VISIBLE
                }
            }
    }
}