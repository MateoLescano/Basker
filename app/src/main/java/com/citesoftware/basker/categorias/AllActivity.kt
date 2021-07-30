package com.citesoftware.basker.categorias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.citesoftware.basker.DataModel
import com.citesoftware.basker.PagerAdapter
import com.citesoftware.basker.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class AllActivity : AppCompatActivity() {

    private var exercisesList = mutableListOf<DataModel>()
    private var tabTitles = mutableListOf<String>()
    private lateinit var pagerAll: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all)

        when(intent.getIntExtra("dia", 1)){

            1 -> {
                exercisesList.add(DataModel(getString(R.string.Tex11),getString(R.string.Dex11) , getString(R.string.Rex11) , R.drawable.gifdrib1d2))
                exercisesList.add(DataModel(getString(R.string.Tex37),getString(R.string.Dex37), getString(R.string.Rex37) , R.drawable.giffin1d3))
                exercisesList.add(DataModel(getString(R.string.Tex29),getString(R.string.Dex29), getString(R.string.Rex29) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex3), getString(R.string.Dex3) , getString(R.string.Rex3) , R.drawable.giftiro1d3))
                exercisesList.add(DataModel(getString(R.string.TFT),getString(R.string.DFT) , getString(R.string.RFT2) , R.drawable.giftiro1d4))
            }
            2 -> {
                exercisesList.add(DataModel(getString(R.string.Tex16), getString(R.string.Dex16), getString(R.string.Rex16) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex27),getString(R.string.Dex27), getString(R.string.Rex27) , R.drawable.gifpost2d1))
                exercisesList.add(DataModel("Up and under","En posición de poste, me acerco al aro, me doy vuelta y hago un amague de tiro, y con el pie de pivot doy un paso para hacer una bandeja hacía el otro lado", "10 por lado" , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex6),getString(R.string.Dex6) , getString(R.string.R5x5) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex7),getString(R.string.Dex7) , getString(R.string.R5x5) , R.drawable.placeholdergif))
            }
            3 -> {
                exercisesList.add(DataModel("Crossover", "", "" , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Flotadora simple","Empiezo dribleando desde fuera de la pintura, entro en diagonal y defino con una flotadora. Me concentro en dar los pasos correctos, en extenderme completamente y en mantener la pose después de tirar", "15 flotadoras por lado." , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Rondo","Corro hacía el aro como para hacer una bandeja, pero freno el movimiento extendiendo el brazo antes de tirar, y me doy vuelta para tirar", "10 por lado" , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex4),getString(R.string.Dex4) , getString(R.string.Rex4) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex9),getString(R.string.Dex9) , getString(R.string.R5x5) , R.drawable.placeholdergif))
            }
        }

        pagerAll = findViewById(R.id.pagerAll)
        tabLayout = findViewById(R.id.tabLayout)
        pagerAll.adapter = PagerAdapter(this, exercisesList)

        for (i in 1..exercisesList.size) {
            tabTitles.add(i.toString())
        }

        TabLayoutMediator(tabLayout, pagerAll) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.all)
        actionbar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}