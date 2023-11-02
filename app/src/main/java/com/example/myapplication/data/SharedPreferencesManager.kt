package com.example.myapplication.data
import android.content.Context
import android.content.SharedPreferences
class SharedPreferencesManager(private var context: Context) {
    private  val name_database = "ME_DATA_BASE"
    private val SharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(name_database,Context.MODE_PRIVATE)
    }
    fun saveUser(user:String){
        val editor =SharedPreferences.edit()
        editor.putString("keyUserPref",user)
        editor.apply()
    }
    fun saveBoolean(){
        val editor =SharedPreferences.edit()
        editor.putBoolean("keyUserPref",true)
        editor.apply()
    }
    }
    fun getUser():String{

     return SharedPreferences.g
    }


fun getBoolean():String{

    return SharedPreferences.getBoolean("keyUserpref","Empty").toString()
}
