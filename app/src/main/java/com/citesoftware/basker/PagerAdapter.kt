package com.citesoftware.basker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class PagerAdapter(private val context: Context, private val exercises: List<DataModel>): RecyclerView.Adapter<PagerAdapter.PageHolder>(){


    inner class PageHolder(view: View): RecyclerView.ViewHolder(view){
        var image : ImageView = itemView.findViewById(R.id.exImg)
        var title: TextView = itemView.findViewById(R.id.tvExTitle)
        var description : TextView = itemView.findViewById(R.id.tvExDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder {
        val view = PageHolder(LayoutInflater.from(context).inflate(R.layout.exercise_layout, parent, false))
        return view
    }

    override fun onBindViewHolder(holder: PageHolder, position: Int) {

        val data = exercises[position]

        holder.title.text = data.title
        holder.description.text = data.description
        holder.image.setImageResource(data.image)
    }

    override fun getItemCount(): Int = exercises.size
}

