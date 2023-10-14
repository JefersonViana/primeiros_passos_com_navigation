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
import com.example.primeiros_passos_com_navigation.databinding.FragmentAddressBinding
import com.example.primeiros_passos_com_navigation.databinding.FragmentPersonalDataBinding
import com.example.primeiros_passos_com_navigation.extensions.text
import com.example.primeiros_passos_com_navigation.model.PersonModel

class AddressFragment : Fragment() {
    private var _binding: FragmentAddressBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<AddressFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, saved: Bundle?): View {
        _binding = FragmentAddressBinding.inflate(inflater, group, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            // VOU DEIXAR OUTRA FORMA DE JUNTAR OS DADOS QUE VEM DE ARGS.MODEL COM A NOVA INSTANCIA DE PERSONMODEL
            //NESSE CASO AQUI É SÓ PASSAR personCopy no lugar de model
//            val personCopy = args.model.copy(
//                street = binding.tilStreet.text,
//                number = binding.tilNumber.text.toInt()
//            )
            val model = PersonModel(
                name = args.model.name,
                age = args.model.age,
                street = binding.tilStreet.text,
                number = binding.tilNumber.text.toInt()
            )
            val directions = AddressFragmentDirections.goToResumeFragment(model)
            findNavController().navigate(directions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}