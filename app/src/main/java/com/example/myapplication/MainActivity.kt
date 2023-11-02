package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.AbsSavedState
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.data.SharedPreferencesManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding
private  lateinit var SharedPref: SharedPreferencesManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding =  ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
       SharedPref= SharedPreferencesManager(this)
        val user = SharedPref.getUser()
        Toast.makeText( this, user, Toast.LENGTH_LONG).show()

        initUI()
    }
    private fun initUI(){
        setupOnClicklistener()
    }

    private fun setupOnClicklistener(){
        binding.btn.setOnClickListener{
            val user =binding.txtUser.text.toString()
            val  pass =binding.txtUser.text.toString()
            val intent = Intent (this,MainActivity2::class.java)

            intent.putExtra("keyuser",user)
            intent.putExtra("keypass",pass)
            SharedPref.saveUser(user)


            startActivity(intent)
        }
    }
}