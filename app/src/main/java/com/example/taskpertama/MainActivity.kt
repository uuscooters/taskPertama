package com.example.taskpertama

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.title = "Register"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val localStorage = LocalStorage(getActivity())

//        membuat variable Edit text
        val fileName = findViewById<EditText>(R.id.input_name)
        val fileEmail = findViewById<EditText>(R.id.input_email)
        val filePassword = findViewById<EditText>(R.id.input_password)

        val list: ArrayList<String> = ArrayList()
        list.add("Mahasiswa")
        list.add("Karyawan")
        list.add("Pengangguran")
        list.add("Lain-Lain")

//        Membuat adapter untuk spinner, untuk menampilkan dropdown dari variable list
        val adapter: ArrayAdapter<String> =
            ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, list)
        spList.adapter = adapter


        if (localStorage.getJob() != -1) {
            spList.setSelection(localStorage.getJob())
        }
        if (localStorage.getGender() != -1) {
//            rgGender.setSelection(localStorage.getGender())
        }

        if (localStorage.getUserName() != null) {
            input_name.setText(localStorage.getUserName())
        }
        if (localStorage.getUserEmail()!= null) {
            input_email.setText(localStorage.getUserEmail())
        }
        if (localStorage.getUserPassword() != null) {
            input_password.setText(localStorage.getUserPassword())
        }

//        membuat real time action pada editText
        input_password.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Toast.makeText(getActivity(), p0!!.toString(), Toast.LENGTH_SHORT).show()

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.e("beforeTextChanged", p0!!.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
                Log.e("afterTextChanged", p0!!.toString())
            }

        })

//        membuat real time action pada checkbox
        cbTerm.setOnCheckedChangeListener { _, b ->
            if (b) { //Kondisi ketika checkbox dicheck
                Toast.makeText(getActivity(), "Anda Menyetujui", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(getActivity(), "Anda tidak Menyetujui", Toast.LENGTH_SHORT).show()
            }
        }

        //Membuat real time action pada radio group
        rgGender.setOnCheckedChangeListener { radioGroup, i ->
            // mendapatkan object radio button yg ada didalam radio group
            val radioButton: RadioButton = radioGroup.findViewById(i)

            if (radioButton.isChecked) { // kondisi ketika radio button dipilih
                Toast.makeText(
                    getActivity(),
                    "Anda Memilih ${radioButton.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

//        membuat real time action pada spinner
        spList.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Log.e("TAG", "Not Implemented")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p2 == (list.size - 1)) { //kondisi ketika user memilih option terakhir pada spinner
                    etOther.visibility = View.VISIBLE
                } else { // Kondisi ketika user tidak memilih option terakhir pada spinner
                    etOther.visibility = View.GONE
                }
            }
        }



        btnSubmit.setOnClickListener {


            if (input_name.text.isNotEmpty() && input_email.text.isNotEmpty() && input_password.text.isNotEmpty()) {
                localStorage.saveUserEmail(input_email.text.toString())
                localStorage.saveUserName(input_name.text.toString())
                localStorage.saveUserPassword(input_password.text.toString())
            }

            localStorage.saveJob(spList.selectedItemPosition)

            startActivity(Intent(getActivity(), LoginActivity::class.java))
        }

    }
    private fun getActivity(): Context {return this}

    override fun onSupportNavigateUp() : Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

}