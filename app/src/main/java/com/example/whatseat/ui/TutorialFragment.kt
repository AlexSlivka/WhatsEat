package com.example.whatseat.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.whatseat.R


class TutorialFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tutorial, container, false)

        view.findViewById<ImageView>(R.id.iv_mail).setOnClickListener {
            Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "whatseat@mail.ru")
                putExtra(Intent.EXTRA_SUBJECT, "Предложение")
                putExtra(Intent.EXTRA_EMAIL, "whatseat@mail.ru")
            }.also { intent -> startActivity(intent) }
        }

        return view
    }
}