package com.example.gridrecyclerviewdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gridrecyclerviewdemo.R
import com.example.gridrecyclerviewdemo.model.ParentData

class ParentAdapter(var parentList: List<ParentData>): RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {


    class ParentViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
        val rcChild = itemView.findViewById<RecyclerView>(R.id.parent_recycleView)

    }

    fun onApplySearch(parentList: List<ParentData>){

        this.parentList = parentList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.parent_items,parent,false)
        return ParentViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return parentList.size
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val currentItem = parentList[position]

        holder.tvTitle.text = currentItem.title
        //implement RV
        holder.rcChild.setHasFixedSize(true)
        holder.rcChild.layoutManager = GridLayoutManager(holder.itemView.context,1,RecyclerView.HORIZONTAL,false)

        val adapter = ChildAdapter(currentItem.childList)

        holder.rcChild.adapter = adapter
    }
}