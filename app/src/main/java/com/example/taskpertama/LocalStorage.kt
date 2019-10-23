package com.example.taskpertama

import android.content.Context
import android.content.SharedPreferences

class LocalStorage(private val context: Context) {

    private val key = "com.example.taskpertama"
    private val private = 0

    private val userEmail = "userEmail"
    private val userName = "userName"
    private val userPassword = "userPassword"
    private val gender = "gender"
    private val job = "job"



    fun saveUserName(string: String){
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(userName, string)
        editor.apply()
    }

    fun getUserName () : String {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)

        return sharedPreferences.getString(userName, "")!!
    }


    fun saveUserEmail(string: String){
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(userEmail, string)
        editor.apply()
    }

    fun getUserEmail() : String {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)

        return sharedPreferences.getString(userEmail, "")!!
    }

    fun saveUserPassword(string: String){
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(userPassword, string)
        editor.apply()
    }

    fun getUserPassword() : String {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)

        return sharedPreferences.getString(userPassword, "")!!
    }

    fun saveJob(int: Int){
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putInt(job, int)
        editor.apply()
    }

    fun getJob() : Int {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)

        return sharedPreferences.getInt(job, -1)
    }

    fun getGender() : Int {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(key, private)

        return sharedPreferences.getInt(gender, -1)
    }

}