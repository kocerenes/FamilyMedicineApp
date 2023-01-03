package com.ekheek.familymedicineapp.presentation.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.ekheek.familymedicineapp.databinding.FragmentContinueRegisterBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContinueRegisterFragment : Fragment() {

    private val args: ContinueRegisterFragmentArgs by navArgs()
    private var _binding: FragmentContinueRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var patientId: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContinueRegisterBinding.inflate(inflater, container, false)
        onClickBtnLogin()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        patientId = args.patientId
    }

    private fun onClickBtnLogin() = binding.btnLogin.setOnClickListener {
        binding.progressBar.visibility = View.VISIBLE
        binding.linear1.visibility = View.INVISIBLE
        createPatientProfile(it)
    }

    private fun createPatientProfile(view: View) {
        val db = Firebase.firestore
        val patient = hashMapOf(
            "id" to patientId,
            "name" to binding.tvName.text.toString(),
            "phoneNumber" to binding.tvPhoneNumber.text.toString(),
            "height" to binding.tvSize.text.toString(),
            "weight" to binding.tvWeight.text.toString(),
        )
        db.collection("patients")
            .add(patient)
            .addOnSuccessListener { documentReference ->
                val action =
                    ContinueRegisterFragmentDirections.actionContinueRegisterFragmentToHomeFragment()
                Navigation.findNavController(view).navigate(action)
                Toast.makeText(context, "Profiliniz Başarıyla Oluşturuldu", Toast.LENGTH_LONG)
                    .show()
                binding.progressBar.visibility = View.INVISIBLE
                binding.linear1.visibility = View.VISIBLE
            }
            .addOnFailureListener { e ->
                println(e.localizedMessage)
            }
    }
}