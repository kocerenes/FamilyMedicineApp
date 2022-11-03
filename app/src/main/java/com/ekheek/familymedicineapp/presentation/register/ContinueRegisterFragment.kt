package com.ekheek.familymedicineapp.presentation.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ekheek.familymedicineapp.data.local.entities.PatientEntity
import com.ekheek.familymedicineapp.databinding.FragmentContinueRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContinueRegisterFragment : Fragment() {

    val args: ContinueRegisterFragmentArgs by navArgs()
    private var _binding: FragmentContinueRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ContinueRegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContinueRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            createPatientProfile(it)
        }
    }

    private fun createPatientProfile(view: View) {
        val patientId = args.patientId
        with(binding) {
            val patientProfile = PatientEntity(
                id = patientId,
                name = tvName.text.toString(),
                weight = tvWeight.text.toString(),
                height = tvSize.text.toString(),
                age = tvAge.text.toString(),
                phoneNumber = tvPhoneNumber.text.toString()
            )
            viewModel.addPatient(patientProfile, view)
        }
    }
}