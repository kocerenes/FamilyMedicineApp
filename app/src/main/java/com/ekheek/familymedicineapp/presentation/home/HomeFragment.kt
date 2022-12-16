package com.ekheek.familymedicineapp.presentation.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ekheek.familymedicineapp.R
import com.ekheek.familymedicineapp.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
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
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        getWelcomeMessage()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToProfilePage()
        navigateToDatePage()
        backToLoginScreen()
        navigateToTakedDatePage()
    }

    @SuppressLint("SetTextI18n")
    private fun getWelcomeMessage() {
        val db = Firebase.firestore
        db.collection("patients")
            .whereEqualTo("id", auth.currentUser!!.uid)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    binding.textViewWelcome.text = "Merhaba ${document.data["name"].toString()}"
                }
                binding.progressBar.visibility = View.INVISIBLE
                binding.scrollView.visibility = View.VISIBLE
            }
    }

    private fun navigateToTakedDatePage() = binding.layoutTakedDates.setOnClickListener {
        val action = HomeFragmentDirections.actionHomeFragmentToTakedDateFragment()
        findNavController().navigate(action)
    }

    private fun backToLoginScreen() = binding.layoutLogOut.setOnClickListener {
        showAlertDialog()
        // to do : if the user is logged out, delete this fragment from backstack
    }

    private fun navigateToDatePage() = binding.layoutDateFamilyDoctor.setOnClickListener {
        val action = HomeFragmentDirections.actionHomeFragmentToDateFamilyDoctorFragment()
        findNavController().navigate(action)
    }

    private fun navigateToProfilePage() = binding.layoutProfile.setOnClickListener {
        val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment()
        findNavController().navigate(action)
    }

    // Confirm deletion alert dialog
    private fun showAlertDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setMessage(R.string.log_out_question)
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
                auth.signOut()
                Toast.makeText(
                    requireContext(),
                    R.string.logged_out_successfully,
                    Toast.LENGTH_LONG
                ).show()
            }.setNegativeButton(getString(R.string.no)) { _, _ ->

            }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}