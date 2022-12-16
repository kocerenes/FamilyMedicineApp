package com.ekheek.familymedicineapp.presentation.taked_date.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ekheek.familymedicineapp.data.local.entities.Appointment
import com.ekheek.familymedicineapp.databinding.ItemTakedDateBinding

class TakedDateAdapter() :
    RecyclerView.Adapter<TakedDateViewHolder>() {

    object DiffCallback : DiffUtil.ItemCallback<Appointment>() {
        override fun areItemsTheSame(oldItem: Appointment, newItem: Appointment): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(oldItem: Appointment, newItem: Appointment): Boolean {
            return oldItem == newItem
        }
    }

    private val diffList = AsyncListDiffer(this, DiffCallback)

    var appointments: List<Appointment?>
        get() = diffList.currentList
        set(value) = diffList.submitList(value)

    override fun onBindViewHolder(holder: TakedDateViewHolder, position: Int) {
        appointments[position]?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TakedDateViewHolder {
        val binding =
            ItemTakedDateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TakedDateViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return appointments.size
    }
}