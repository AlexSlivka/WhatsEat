package com.example.whatseat.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whatseat.R
import com.example.whatseat.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_container, MainFragment())
                .commit()
        }
    }
}