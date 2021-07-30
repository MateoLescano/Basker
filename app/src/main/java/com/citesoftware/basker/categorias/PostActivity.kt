package com.citesoftware.basker.categorias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.citesoftware.basker.DataModel
import com.citesoftware.basker.PagerAdapter
import com.citesoftware.basker.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PostActivity : AppCompatActivity() {

    private var exercisesList = mutableListOf<DataModel>()
    private var tabTitles = mutableListOf<String>()
    private lateinit var pagerAll: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        when(intent.getIntExtra("dia", 1)){

            1 -> {

                exercisesList.add(DataModel(getString(R.string.Tex23),getString(R.string.Dex23), getString(R.string.Rex23) , R.drawable.gifpost1d1))
                exercisesList.add(DataModel(getString(R.string.Tex24),getString(R.string.Dex24), getString(R.string.Rex24) , R.drawable.gifpost1d2))
                exercisesList.add(DataModel(getString(R.string.Tex25),getString(R.string.Dex25), getString(R.string.Rex25) , R.drawable.gifpost1d3))
                exercisesList.add(DataModel(getString(R.string.Tex26),getString(R.string.Dex26), getString(R.string.Rex26) , R.drawable.gifpost1d4))

            }
            2 -> {
                exercisesList.add(DataModel(getString(R.string.Tex27),getString(R.string.Dex27), getString(R.string.Rex27) , R.drawable.gifpost2d1))
                exercisesList.add(DataModel(getString(R.string.Tex28),getString(R.string.Dex28), getString(R.string.Rex28) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex29),getString(R.string.Dex29), getString(R.string.Rex29) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex30),getString(R.string.Dex30), getString(R.string.Rex30) , R.drawable.placeholdergif))
            }
            3 -> {
                exercisesList.add(DataModel(getString(R.string.Tex31),getString(R.string.Dex31), getString(R.string.Rex30)  , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex32),getString(R.string.Dex32), getString(R.string.Rex32) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex33),getString(R.string.Dex33), getString(R.string.Rex33) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex34),getString(R.string.Dex34), getString(R.string.Rex34) , R.drawable.placeholdergif))
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
        actionbar!!.title = getString(R.string.postmoves)
        actionbar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}