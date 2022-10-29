package com.ekheek.familymedicineapp.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.auth.FirebaseAuth

class RegisterRepository() {


    fun register(email: String, password: String, auth: FirebaseAuth) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    println("success")
                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                }
            }
    }
}