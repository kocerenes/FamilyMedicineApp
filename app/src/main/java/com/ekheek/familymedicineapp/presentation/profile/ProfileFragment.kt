package com.ekheek.familymedicineapp.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ekheek.familymedicineapp.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        getProfileData()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getProfileData() {
        val db = Firebase.firestore
        db.collection("patients")
            .whereEqualTo("id", auth.currentUser!!.uid)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    bindUI(document)
                }
            }
    }

    private fun bindUI(document: QueryDocumentSnapshot) {
        binding.layout1.visibility = View.VISIBLE
        binding.progressBar.visibility = View.INVISIBLE
        binding.textViewName.text = document.data["name"] as String
        binding.textView7.text = auth.currentUser?.email
        binding.textView8.text = document.data["phoneNumber"] as String
        binding.textView9.text = document.data["height"] as String
        binding.textView10.text = document.data["weight"] as String
    }
}