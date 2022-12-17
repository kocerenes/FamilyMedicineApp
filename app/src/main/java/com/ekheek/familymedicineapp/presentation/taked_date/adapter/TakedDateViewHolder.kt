package com.ekheek.familymedicineapp.presentation.taked_date.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.ekheek.familymedicineapp.data.local.entities.Appointment
import com.ekheek.familymedicineapp.databinding.ItemTakedDateBinding
import java.text.SimpleDateFormat
import java.util.*

class TakedDateViewHolder(
    private val binding: ItemTakedDateBinding,
) : RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SimpleDateFormat")
    fun bind(appointment: Appointment) = binding.apply {
        val sdf = SimpleDateFormat("dd/MM/yy hh:mm a")
        val netDate = Date(appointment.date.toDate().time)
        val date =sdf.format(netDate)

        textViewDoctorName.text = appointment.doctorName
        textViewDate.text = date.toString()
        textViewHospitalName.text = appointment.medicineName
        textViewDoctorOpinion.text = appointment.medicineAddress
    }
}