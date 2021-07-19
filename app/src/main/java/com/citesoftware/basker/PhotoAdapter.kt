package com.citesoftware.basker

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.citesoftware.basker.categorias.*

class PhotoAdapter(val context: Context) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    var dataList = emptyList<MainDataModel>()

    internal fun setDataList(dataList: List<MainDataModel>){
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
              var intent = Intent(context, MainActivity::class.java)
              val primerElemento = dataList.elementAt(1)


              when(title.text){
                  context.getString(R.string.shooting) -> {
                      intent = Intent(context, ShootingActivity::class.java)
                  }
                  context.getString(R.string.dribbling) -> {
                      intent = Intent(context, DribblingActivity::class.java)
                  }
                  context.getString(R.string.finishing) -> {
                      intent = Intent(context, FinishingActivity::class.java)
                  }
                  context.getString(R.string.postmoves) -> {
                      intent = Intent(context, PostActivity::class.java)
                  }
                  context.getString(R.string.defense) -> {
                      intent = Intent(context, DefenseActivity::class.java)
                  }

                  context.getString(R.string.all) -> {
                      intent = Intent(context, AllActivity::class.java)
                  }
              }
              intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
              intent.putExtra("dia", primerElemento.dia)
              context.startActivity(intent)
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