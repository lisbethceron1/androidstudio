package com.example.myapplication.data
import android.content.Context
import android.content.SharedPreferences
import java.lang.IllegalArgumentException

class SharedPreferencesManager(private var context: Context) {
    private val name_database = "ME_DATA_BASE"
    private val SharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(name_database, Context.MODE_PRIVATE)
    }

    fun saveUser(user: String) {
        val editor = SharedPreferences.edit()
        editor.putString("KeyUserPref", user)
        editor.apply()
    }

    fun saveBoolean() {
        val editor = SharedPreferences.edit()
        editor.putBoolean("miBoolean", true)
        editor.apply()
    }

    fun getUser(): String {

        return SharedPreferences.getString("KeyUserPref", "Empty").toString()
    }


    fun getUserIsLogged(): Boolean {

        return SharedPreferences.getBoolean("miBoolean", false)
    }
    fun removeSharedPref(key: String){
        val editor=SharedPreferences.edit()

        editor.remove(key)
        editor.apply()
    }
    //SOLUCION  A POSIBLE PROBLEMA DE ESCABILIDAD
    fun savePref(key: String, value:Any){
      val editor= SharedPreferences.edit()
        when(value){
            is String -> editor.putString(key,value)
            is Int -> editor.putInt(key,value)
            is Boolean -> editor. putBoolean(key,value)
            is Float -> editor.putFloat(key,value)
            is Long -> editor.putLong(key,value)
            else -> throw  IllegalArgumentException("este valor no puede ser valido")
        }
        editor.apply()
    }

    fun getPreff(key: String, defaultValue:Any): Any{
        val  SharedPreferences= context.getSharedPreferences(name_database, Context.MODE_PRIVATE)
       return when(defaultValue){
            is String -> SharedPreferences.getString(key, defaultValue)
            is Int -> SharedPreferences.getInt(key, defaultValue)
            is Boolean -> SharedPreferences.getBoolean(key, defaultValue)
            is Float -> SharedPreferences.getFloat(key, defaultValue)
            is Long -> SharedPreferences.getLong(key, defaultValue)
            else -> throw IllegalArgumentException("no se encontro en la base de datos")



        }!!

    }
}
