package com.example.vulntechapp.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vulntechapp.HomeData
import com.example.vulntechapp.R

class HomeAdapter(
    private var homes : List<HomeData>
): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    inner class HomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.textView_name)
        val category: TextView = itemView.findViewById(R.id.textView_category)
        val points : TextView = itemView.findViewById(R.id.textView_points)
        val solve : TextView = itemView.findViewById(R.id.textView_solves)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home,parent,false)
        return HomeViewHolder(view)

    }

    override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder, position: Int) {
        val home = homes[position]
        holder.name.text = home.name
        holder.category.text = "Category: ${home.category}"
        holder.points.text = "Points: ${home.points}"
        holder.solve.text = "Solves ${home.solve}"
    }

    override fun getItemCount(): Int {
        return homes.size
    }

    fun updateData(newHomeData: List<HomeData>){
        this.homes = newHomeData
        notifyDataSetChanged()
    }
}