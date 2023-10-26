package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.AbsSavedState
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.databinding.ActivitySegunda2Binding
















class SegundaActivity2: AppCompatActivity() {

    private lateinit var binding: SegundaActivity2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding =  ActivitySegunda2Binding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        initUI()
    }
    private fun initUI(){
        setupOnClicklistener()
    }

    private fun setupOnClicklistener(){
        binding.btn.setOnClickListener{
            val intent = Intent (this,segundaActivity2::class.java)

            startActivity(intent)
        }
    }
}