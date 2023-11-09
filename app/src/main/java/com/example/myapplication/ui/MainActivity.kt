package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.myapplication.R
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
        val boolean = SharedPref.getUserIsLogged()
        Toast.makeText( this, user, Toast.LENGTH_LONG).show()
        if (boolean) {
        val intent = Intent(this, MainActivity2::class.java)
            startActivity((intent))
        }
        initUI()
    }
    private fun initUI(){
        setupOnClicklistener()
    }

    private fun setupOnClicklistener(){
        binding.btn.setOnClickListener{
            val user =binding.txtUser.text.toString()
            val  pass =binding.txtUser.text.toString()
            val intent = Intent (this, MainActivity2::class.java)

            intent.putExtra("keyuser",user)
            intent.putExtra("keypass",pass)
            //SharedPref.saveUser(user)
            SharedPref.savePref("userLogged",true)
            SharedPref.savePref("nameUser",user)
            SharedPref.savePref("passUser",pass)


            startActivity(intent)
        }
    }
}