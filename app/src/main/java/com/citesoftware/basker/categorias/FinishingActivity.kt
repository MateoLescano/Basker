package com.citesoftware.basker.categorias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.citesoftware.basker.DataModel
import com.citesoftware.basker.PagerAdapter
import com.citesoftware.basker.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FinishingActivity : AppCompatActivity() {

    private var exercisesList = mutableListOf<DataModel>()
    private var tabTitles = mutableListOf<String>()
    private lateinit var pagerAll: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finishing)

        when(intent.getIntExtra("dia", 1)){

            1 -> {
                exercisesList.add(DataModel(getString(R.string.Tex35),getString(R.string.Dex35), getString(R.string.Rex35) , R.drawable.giffin1d1))
                exercisesList.add(DataModel(getString(R.string.Tex36),getString(R.string.Dex36), getString(R.string.Rex36) , R.drawable.giffin1d2))
                exercisesList.add(DataModel(getString(R.string.Tex44),getString(R.string.Dex44), getString(R.string.Rex35) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex37),getString(R.string.Dex37), getString(R.string.Rex37) , R.drawable.giffin1d3))
            }
            2 -> {
                exercisesList.add(DataModel(getString(R.string.Tex38),getString(R.string.Dex38), getString(R.string.Rex38) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex40),getString(R.string.Dex40), getString(R.string.Rex40) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex45),getString(R.string.Dex45), getString(R.string.Rex37) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex46),getString(R.string.Dex46), getString(R.string.Rex37) , R.drawable.placeholdergif))
            }
            3 -> {
                exercisesList.add(DataModel(getString(R.string.Tex41),getString(R.string.Dex41), getString(R.string.Rex41) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex42),getString(R.string.Dex42), getString(R.string.Rex42) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex43),getString(R.string.Dex43), getString(R.string.Rex43) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex39),getString(R.string.Dex39), getString(R.string.Rex39) , R.drawable.placeholdergif))
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
        actionbar!!.title = getString(R.string.finishing)
        actionbar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}