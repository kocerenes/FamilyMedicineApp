package com.ekheek.familymedicineapp.presentation.taked_date.adapter

import androidx.recyclerview.widget.RecyclerView
import com.ekheek.familymedicineapp.data.local.entities.Appointment
import com.ekheek.familymedicineapp.databinding.ItemTakedDateBinding

class TakedDateViewHolder(
    private val binding: ItemTakedDateBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(appointment: Appointment) = binding.apply {
        textViewDoctorName.text = appointment.doctorName
        textViewDate.text = appointment.date
        textViewHospitalName.text = appointment.medicineName
        textViewDoctorOpinion.text = appointment.medicineAddress
    }
}