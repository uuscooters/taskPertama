package com.example.taskpertama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        //Membuat variable adapter dari class PostAdapter
        val adapter = PostAdapter()
        //Membuat inisialisasi dari interface yg ada di PostAdapter
        adapter.onListener = object: PostAdapter.OnListener {
            override fun onClick(position: Int) {
                Toast.makeText(this@ListActivity, "Anda mengklick image pada posisi ${position}", Toast.LENGTH_SHORT).show()
            }
        }

        val localStorage = LocalStorage(this)
        if (localStorage.getUserName().isNotEmpty()) {
            Toast.makeText(this, "Full name : ${localStorage.getUserName()}", Toast.LENGTH_LONG).show()
        }

        supportActionBar!!.title = "RecyclerView"

        //Membuat recycle scoll ke bawah atau vertical
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        //Membuat list resouce id untuk mengubah gambar di setiap item
        val list: ArrayList<Int> = ArrayList()
        list.add(R.mipmap.ic_launcher_round)
        list.add(R.mipmap.ic_launcher)
        list.add(R.mipmap.ic_launcher_round)
        list.add(R.mipmap.ic_launcher)
        list.add(R.mipmap.ic_launcher_round)
        list.add(R.mipmap.ic_launcher)
        list.add(R.mipmap.ic_launcher_round)
        list.add(R.mipmap.ic_launcher)
        list.add(R.mipmap.ic_launcher_round)

        //Menset list ke adapter
        adapter.list = list

        //Mensetting rvList
        rvList.apply {
            setAdapter(adapter)
            setHasFixedSize(true)
            setLayoutManager(layoutManager)
        }
    }
}