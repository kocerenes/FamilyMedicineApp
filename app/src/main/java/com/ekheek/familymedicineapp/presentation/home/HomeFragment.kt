package com.ekheek.familymedicineapp.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ekheek.familymedicineapp.R
import com.ekheek.familymedicineapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToProfilePage()
        navigateToDatePage()
        backToLoginScreen()
        navigateToTakedDatePage()
    }

    private fun navigateToTakedDatePage() = binding.layoutTakedDates.setOnClickListener {
        val action = HomeFragmentDirections.actionHomeFragmentToTakedDateFragment()
        findNavController().navigate(action)
    }

    private fun backToLoginScreen() = binding.layoutLogOut.setOnClickListener {
        // to do : log out from firebase method
        findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        // to do : check if the user logged out successfully
        // to do : log out toast message
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}