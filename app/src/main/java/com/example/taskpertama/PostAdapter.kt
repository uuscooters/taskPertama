package com.example.taskpertama

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.row_item.view.*

class PostAdapter : RecyclerView.Adapter<PostAdapter.ViewHolder>(){

    var list: ArrayList<Int> = ArrayList()

    var onListener: OnListener? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int { return list.size }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Code untuk mengubah gambar sesuai dengan index
        Glide.with(holder.itemView).load(list[position]).apply(RequestOptions.circleCropTransform()).into(holder.itemView.ivUser)

        //Memberikan aksi pada interface
        holder.itemView.ivUser.setOnClickListener { onListener!!.onClick(position) }
    }

    //Membuat interface
    interface OnListener {
        fun onClick(position: Int)
    }
}