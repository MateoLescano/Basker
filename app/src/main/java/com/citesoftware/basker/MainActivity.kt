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

        dataList.add(DataModel("Tiro", "Tiro a distnacia", R.drawable.shooting))
        dataList.add(DataModel("Dribbling", "Moves", R.drawable.dribbling))
        dataList.add(DataModel("Finishing", "Layups", R.drawable.finishing))
        dataList.add(DataModel("Postmoves", "Footwork", R.drawable.post))
        dataList.add(DataModel("Defensa", "Clampas", R.drawable.defense))
        dataList.add(DataModel("Pase", "Dimes", R.drawable.finishing))
        dataList.add(DataModel("Rebotes", "El rebo", R.drawable.rebounding))
        dataList.add(DataModel("Todas", "Mixto", R.drawable.all))
        photoAdapter.setDataList(dataList)



    }
}