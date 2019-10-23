package com.example.taskpertama

import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val localStorage = LocalStorage(getActivity())

        if (localStorage.getUserName() != null) {
            Email.setText(localStorage.getUserName())
        }

        if (localStorage.getUserPassword() != null) {
            Password.setText(localStorage.getUserPassword())
        }

        btnlogin.setOnClickListener {

            if (localStorage.getUserName() != "" && localStorage.getUserPassword() != "") {
                    startActivity(Intent(getActivity(), ListActivity::class.java))
                    finish()
                } else {
                Toast.makeText(getActivity(), "Login Failed", Toast.LENGTH_SHORT)
            }
        }


        tvRegister.setOnClickListener {
            startActivity(Intent(getActivity(), MainActivity::class.java))
        }

        if (localStorage.getUserName().isNotEmpty()) {
            Toast.makeText(getActivity(), "Full Name : ${localStorage.getUserName()}", Toast.LENGTH_LONG).show()
        }
    }

    private fun getActivity(): Context { return this}
}

