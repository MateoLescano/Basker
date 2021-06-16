package com.citesoftware.basker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhotoAdapter(val context: Context) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    var dataList = emptyList<DataModel>()

    internal fun setDataList(dataList: List<DataModel>){
        this.dataList = dataList
        notifyDataSetChanged()
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image : ImageView
        var title: TextView
        var description : TextView

        init {
            image = itemView.findViewById(R.id.img1)
            title = itemView.findViewById(R.id.tvImgTitle)
            description = itemView.findViewById(R.id.tvImgDescr)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]

        holder.title.text = data.title
        holder.description.text = data.title
        holder.image.setImageResource(data.image)
    }

    override fun getItemCount(): Int = dataList.size
}