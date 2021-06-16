package com.citesoftware.basker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var photoAdapter: PhotoAdapter
    private var dataList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.mainRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        photoAdapter = PhotoAdapter(applicationContext)
        recyclerView.adapter = photoAdapter

        dataList.add(DataModel("Titulito", "Kionda", R.drawable.aaa))
        dataList.add(DataModel("Titulito2", "Kionda2", R.drawable.bbb))
        dataList.add(DataModel("Titulito3", "Kionda3", R.drawable.pdp))

        photoAdapter.setDataList(dataList)
    }
}