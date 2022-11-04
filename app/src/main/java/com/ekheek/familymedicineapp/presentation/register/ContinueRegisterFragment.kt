package com.ekheek.familymedicineapp.presentation.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.ekheek.familymedicineapp.data.local.entities.PatientEntity
import com.ekheek.familymedicineapp.databinding.FragmentContinueRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContinueRegisterFragment : Fragment() {

    private val args: ContinueRegisterFragmentArgs by navArgs()
    private var _binding: FragmentContinueRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ContinueRegisterViewModel by viewModels()
    private lateinit var patientId: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContinueRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        patientId = args.patientId
        onClickBtnLogin()
    }

    private fun onClickBtnLogin() = binding.btnLogin.setOnClickListener {
        createPatientProfile()
        val action =
            ContinueRegisterFragmentDirections.actionContinueRegisterFragmentToProfileFragment(
                patientId
            )
        Navigation.findNavController(it).navigate(action)
    }

    private fun createPatientProfile() {
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
            viewModel.addPatient(patientProfile)
        }
    }
}