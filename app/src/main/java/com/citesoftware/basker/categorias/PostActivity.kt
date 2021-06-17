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

        exercisesList.add(DataModel(getString(R.string.shooting), getString(R.string.DescTiro), R.drawable.shooting))
        exercisesList.add(DataModel(getString(R.string.shooting), getString(R.string.DescDribbling), R.drawable.shooting))
        exercisesList.add(DataModel(getString(R.string.shooting), getString(R.string.DescFinishing), R.drawable.shooting))
        exercisesList.add(DataModel(getString(R.string.shooting), getString(R.string.DescTiro), R.drawable.shooting))
        exercisesList.add(DataModel(getString(R.string.shooting), getString(R.string.DescDribbling), R.drawable.shooting))
        exercisesList.add(DataModel(getString(R.string.shooting), getString(R.string.DescFinishing), R.drawable.shooting))
        exercisesList.add(DataModel(getString(R.string.shooting), getString(R.string.DescTiro), R.drawable.shooting))
        exercisesList.add(DataModel(getString(R.string.shooting), getString(R.string.DescDribbling), R.drawable.shooting))
        exercisesList.add(DataModel(getString(R.string.shooting), getString(R.string.DescFinishing), R.drawable.shooting))
        exercisesList.add(DataModel(getString(R.string.shooting), getString(R.string.DescTiro), R.drawable.shooting))

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