package com.citesoftware.basker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
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

        dataList.add(DataModel(getString(R.string.shooting), "Tiro a distancia", R.drawable.shooting))
        dataList.add(DataModel(getString(R.string.dribbling), "Moves", R.drawable.dribbling))
        dataList.add(DataModel(getString(R.string.finishing), "Layups", R.drawable.finishing))
        dataList.add(DataModel(getString(R.string.postmoves), "Footwork", R.drawable.post))
        dataList.add(DataModel(getString(R.string.defense), "Clampas", R.drawable.defense))
        dataList.add(DataModel(getString(R.string.passing), "Dimes", R.drawable.passing))
        dataList.add(DataModel(getString(R.string.rebounding), "El rebo", R.drawable.rebounding))
        dataList.add(DataModel(getString(R.string.all), "Mixto", R.drawable.all))
        photoAdapter.setDataList(dataList)


    }
}