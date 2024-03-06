package com.ardev.heroapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide

class ListProlangAdapter(private val listProlang: ArrayList<ProgrammingLanguage>): RecyclerView.Adapter<ListProlangAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val prolangName: TextView = itemView.findViewById(R.id.tv_prolang_name)
        val prolangDesc: TextView = itemView.findViewById(R.id.tv_prolang_desc)
        val prolangPhoto: ImageView = itemView.findViewById(R.id.img_prolang_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.prolang_card, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listProlang.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listProlang[position]
        holder.apply {
            prolangName.text = name
            prolangDesc.text = description
        }
        Glide.with(holder.itemView.context).load(photo).into(holder.prolangPhoto)

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("PROLANG_DATA", listProlang[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}