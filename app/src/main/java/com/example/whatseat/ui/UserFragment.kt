package com.example.whatseat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.whatseat.R


class UserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user, container, false)

        view.findViewById<Button>(R.id.btn_autoris).setOnClickListener {
            findNavController().navigate(R.id.action_userFragment_to_authorizationFragment)
        }

        view.findViewById<Button>(R.id.btn_registr).setOnClickListener {
            findNavController().navigate(R.id.action_userFragment_to_registrationFragment)
        }

        return view
    }


}