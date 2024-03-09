package com.example.gridrecyclerviewdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.gridrecyclerviewdemo.R
import com.example.gridrecyclerviewdemo.model.ChildData

class ChildAdapter(val childList: List<ChildData>): RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {


    class ChildViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        val imgChild = itemView.findViewById<ImageView>(R.id.child_imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val item_view = LayoutInflater.from(parent.context).inflate(R.layout.child_items,parent,false)
        return ChildViewHolder(item_view)
    }

    override fun getItemCount(): Int {
        return childList.size
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val currentItems = childList[position]

        holder.imgChild.setImageResource(currentItems.image)
    }
}