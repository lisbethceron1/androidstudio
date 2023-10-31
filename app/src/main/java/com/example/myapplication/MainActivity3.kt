package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        binding =  ActivityMain3Binding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        initUI()
    }
    private fun initUI(){
        setupOnClicklistener()
    }

    private fun setupOnClicklistener(){
        binding.btnn.setOnClickListener{
            val intent = Intent (this,MainActivity::class.java)

            startActivity(intent)
        }
    }
}