package com.citesoftware.basker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PhotoAdapter(val context: Context) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    var dataList = emptyList<DataModel>()

    internal fun setDataList(dataList: List<DataModel>){
        this.dataList = dataList
        notifyDataSetChanged()
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image : ImageView = itemView.findViewById(R.id.img1)
        var title: TextView = itemView.findViewById(R.id.tvImgTitle)
        var description : TextView = itemView.findViewById(R.id.tvImgDescr)

        init {
          itemView.setOnClickListener {
              Toast.makeText(itemView.context,"Click en ${title.text}", Toast.LENGTH_SHORT).show()
          }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]

        holder.title.text = data.title
        holder.description.text = data.description
        holder.image.setImageResource(data.image)
    }

    override fun getItemCount(): Int = dataList.size
}