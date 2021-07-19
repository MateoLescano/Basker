package com.citesoftware.basker.categorias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.citesoftware.basker.DataModel
import com.citesoftware.basker.PagerAdapter
import com.citesoftware.basker.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class ShootingActivity : AppCompatActivity() {
    private var exercisesList = mutableListOf<DataModel>()
    private var tabTitles = mutableListOf<String>()
    private lateinit var pagerAll: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shooting)

        when(intent.getIntExtra("dia", 1)){

            1 -> {
                exercisesList.add(DataModel(getString(R.string.Tex1), getString(R.string.Dex1), getString(R.string.Rex1) , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Media distancia estacionario", "Tiro desde media distancia concentrandome en la mecanica de tiro." , "25 tiros encestados." , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex3), getString(R.string.Dex3) , getString(R.string.Rex3) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.TFT),getString(R.string.DFT) , getString(R.string.RFT1) , R.drawable.placeholdergif))
            }
            2 -> {
                exercisesList.add(DataModel(getString(R.string.Tex2), getString(R.string.Dex2), getString(R.string.Rex2) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex5),getString(R.string.DEX5) , getString(R.string.Rex5) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex6),getString(R.string.Dex6) , getString(R.string.R5x5) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex7),getString(R.string.Dex7) , getString(R.string.R5x5) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.TFT),getString(R.string.DFT) , getString(R.string.RFT2) , R.drawable.placeholdergif))
            }
            3 -> {
                exercisesList.add(DataModel(getString(R.string.Tex2), getString(R.string.Dex2), getString(R.string.Rex2) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex8),getString(R.string.Dex8) , getString(R.string.Rex8) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex4),getString(R.string.Dex4) , getString(R.string.Rex4) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex9),getString(R.string.Dex9) , getString(R.string.R5x5) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.TFT),getString(R.string.DFT) , getString(R.string.RFT3) , R.drawable.placeholdergif))
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
        actionbar!!.title = getString(R.string.shooting)
        actionbar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}