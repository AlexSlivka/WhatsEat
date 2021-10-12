package com.example.whatseat.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whatseat.R

class AuthorizationFragment : Fragment() {

    companion object {
        fun newInstance() = AuthorizationFragment()
    }

    private lateinit var viewModel: AuthorizationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.authorization_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthorizationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}