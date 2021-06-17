package com.citesoftware.basker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var photoAdapter: PhotoAdapter
    private var nroDia: Int = 0
    private var dataList = mutableListOf<MainDataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Recyclerview

        recyclerView = findViewById(R.id.mainRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        photoAdapter = PhotoAdapter(applicationContext)
        recyclerView.adapter = photoAdapter


        //spinner

        val spinner: Spinner = findViewById(R.id.spinner)
        val values: Array<String> = arrayOf(getString(R.string.dia1), getString(R.string.dia2), getString(R.string.dia3))

        val adapter = ArrayAdapter(this, R.layout.spinner_layout,values)
        adapter.setDropDownViewResource(R.layout.spinner_dropdown)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this


        cargarCategorias()

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val dia = parent?.getItemAtPosition(position).toString()
        when (dia){

            getString(R.string.dia1) -> {
                nroDia = 1
            }
            getString(R.string.dia2) -> {
                nroDia = 2
            }
            getString(R.string.dia3) -> {
                nroDia = 3
            }
        }
        cargarCategorias()
    }

    private fun cargarCategorias(){
        dataList.clear()
        dataList.add(MainDataModel(getString(R.string.shooting), getString(R.string.DescTiro), R.drawable.shooting,nroDia))
        dataList.add(MainDataModel(getString(R.string.dribbling), getString(R.string.DescDribbling), R.drawable.dribbling,nroDia))
        dataList.add(MainDataModel(getString(R.string.finishing), getString(R.string.DescFinishing), R.drawable.finishing,nroDia))
        dataList.add(MainDataModel(getString(R.string.postmoves), getString(R.string.DescPost), R.drawable.post,nroDia))
        dataList.add(MainDataModel(getString(R.string.defense), getString(R.string.DescDefense), R.drawable.defense,nroDia))
        dataList.add(MainDataModel(getString(R.string.passing), getString(R.string.DescPase), R.drawable.passing,nroDia))
        dataList.add(MainDataModel(getString(R.string.rebounding), getString(R.string.DescRebound), R.drawable.rebounding,nroDia))
        dataList.add(MainDataModel(getString(R.string.all), getString(R.string.DescAll), R.drawable.all,nroDia))
        photoAdapter.setDataList(dataList)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}