package com.example.pracricaformulario.ui.pantallasMain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pracricaformulario.R
import com.example.pracricaformulario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}