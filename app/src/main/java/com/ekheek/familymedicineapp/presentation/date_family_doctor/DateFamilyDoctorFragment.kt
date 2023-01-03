package com.ekheek.familymedicineapp.presentation.date_family_doctor

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.ekheek.familymedicineapp.databinding.FragmentDateFamilyDoctorBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DateFamilyDoctorFragment : Fragment() {

    private var _binding: FragmentDateFamilyDoctorBinding? = null
    private val binding get() = _binding!!
    private var selectDate = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDateFamilyDoctorBinding.inflate(inflater, container, false)
        onClickBtnTakeAppointment()
        getDate()
        return binding.root
    }

    private fun getDate() {
        val today = Calendar.getInstance()
        binding.datePicker.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            val month = month + 1
            val msg = "$day-$month-$year"
            selectDate = msg
        }
    }

    private fun onClickBtnTakeAppointment() = binding.btnTakeAppointment.setOnClickListener {
        binding.progressBar.visibility = View.VISIBLE
        binding.linear1.visibility = View.INVISIBLE
        takeAppointment(it)
    }

    @SuppressLint("SimpleDateFormat")
    private fun takeAppointment(view: View) {
        val db = Firebase.firestore
        val auth = Firebase.auth

        val date = SimpleDateFormat("dd-MM-yyyy").parse(selectDate)
        val appointment = hashMapOf(
            "id" to auth.currentUser!!.uid,
            "doctorName" to binding.familyDoctorNameTextView.text.toString(),
            "medicineName" to binding.textView2.text.toString(),
            "medicineUnit" to binding.medicineUnitTextView.text.toString(),
            "medicineAddress" to binding.medicineAddressTextView.text.toString(),
            "appointmentDate" to date,
        )
        db.collection("appointments")
            .add(appointment)
            .addOnSuccessListener { documentReference ->
                val action =
                    DateFamilyDoctorFragmentDirections.actionDateFamilyDoctorFragmentToHomeFragment()
                Navigation.findNavController(view).navigate(action)
                Toast.makeText(context, "Randevunuz Başarıyla Alındı.", Toast.LENGTH_LONG)
                    .show()
                binding.progressBar.visibility = View.INVISIBLE
                binding.linear1.visibility = View.VISIBLE
            }
    }
}