package com.ekheek.familymedicineapp.presentation.taked_date

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ekheek.familymedicineapp.data.local.entities.Appointment
import com.ekheek.familymedicineapp.databinding.FragmentTakedDateBinding
import com.ekheek.familymedicineapp.presentation.taked_date.adapter.TakedDateAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TakedDateFragment : Fragment() {
    private var _binding: FragmentTakedDateBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private var takedDateAdapter = TakedDateAdapter()
    private var appointmentFromFirebase: MutableList<Appointment> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTakedDateBinding.inflate(inflater, container, false)
        getAppointmentData()
        return binding.root
    }

    private fun getAppointmentData() {
        val db = Firebase.firestore
        db.collection("appointments")
            .whereEqualTo("id", auth.currentUser!!.uid)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    appointmentFromFirebase.add(
                        Appointment(
                            document.data["appointmentDate"] as String,
                            document.data["medicineName"] as String,
                            document.data["doctorName"] as String,
                            document.data["medicineAddress"] as String
                        )
                    )
                }
            }.addOnCompleteListener {
                bindUI()
            }
    }

    private fun bindUI() {
        binding.rvAppointment.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvAppointment.adapter = takedDateAdapter
        takedDateAdapter.appointments = appointmentFromFirebase
        if (appointmentFromFirebase.isNullOrEmpty()) {
            binding.tvError.visibility = View.VISIBLE
            binding.ivError.visibility = View.VISIBLE
            binding.rvAppointment.visibility = View.INVISIBLE
            binding.progressBar.visibility = View.INVISIBLE
        } else {
            binding.rvAppointment.visibility = View.VISIBLE
            binding.progressBar.visibility = View.INVISIBLE
        }
    }
}