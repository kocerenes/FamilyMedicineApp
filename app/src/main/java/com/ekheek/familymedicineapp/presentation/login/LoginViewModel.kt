package com.ekheek.familymedicineapp.presentation.login

import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {


    val progressBar: MutableLiveData<Boolean> = MutableLiveData()
    init {
        progressBar.postValue(false)
    }

    fun login(email: String, password: String, auth: FirebaseAuth, view: View) {
        progressBar.postValue(true)
        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener() { task ->
                    if (task.isSuccessful) {
                        val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                        Navigation.findNavController(view).navigate(action)
                        progressBar.postValue(false)
                    } else {
                        progressBar.postValue(false)
                        Toast.makeText(
                            view.context,
                            "Lütfen email ve şifreyi doğru giriniz.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        } else {
            progressBar.postValue(false)
            Toast.makeText(view.context, "Email ve şifre boş olamaz!", Toast.LENGTH_LONG).show()
        }
    }
}