package com.example.xmlformatassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.studnview.view.*

class MyAdapter(val al:ArrayList<Student>):RecyclerView.Adapter<MyAdapter.VH>() {
    class VH(itemView:View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.studnview,parent,false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val txt = al[position]
        val id = txt.id
        val name = txt.name
        val marks = txt.marks
        holder.itemView.apply {
            textView.text = "$id\n$name\n$marks\n\n"
        }
    }

    override fun getItemCount(): Int = al.size
}