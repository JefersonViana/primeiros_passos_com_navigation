package com.example.primeiros_passos_com_navigation.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.primeiros_passos_com_navigation.databinding.FragmentResumeBinding
import com.example.primeiros_passos_com_navigation.extensions.text
import com.example.primeiros_passos_com_navigation.model.PersonModel

class ResumeFragment: Fragment() {
    private var _binding: FragmentResumeBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<ResumeFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentResumeBinding.inflate(inflater, group, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "onViewCreated: ${args.resumeArgs}", )
        binding.tvPerson.text = args.resumeArgs.person
        binding.tvAddress.text = args.resumeArgs.address
        binding.btnReturnStart.setOnClickListener {
            val directions = ResumeFragmentDirections.actionResumeFragmentToPersonalDataFragment()
            findNavController().navigate(directions)

        }
        //  TODO mandar o dados para outro fragment
        // TODO navegar entre os fragment
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}