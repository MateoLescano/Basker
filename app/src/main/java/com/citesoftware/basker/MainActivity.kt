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
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.ArrayDia,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
            spinner.onItemSelectedListener = this
        }

        cargarCategorias()

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val dia = parent?.getItemAtPosition(position).toString()
        when (dia){

            "Dia 1" -> {
                nroDia = 1
            }
            "Dia 2" -> {
                nroDia = 2
            }
            "Dia 3" -> {
                nroDia = 3
            }
        }
        cargarCategorias()
    }

    private fun cargarCategorias(){
        dataList.clear()
        dataList.add(MainDataModel(getString(R.string.shooting), nroDia.toString(), R.drawable.shooting,nroDia))
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