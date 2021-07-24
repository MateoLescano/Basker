package com.citesoftware.basker.categorias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.citesoftware.basker.DataModel
import com.citesoftware.basker.PagerAdapter
import com.citesoftware.basker.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DribblingActivity : AppCompatActivity() {

    private var exercisesList = mutableListOf<DataModel>()
    private var tabTitles = mutableListOf<String>()
    private lateinit var pagerAll: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dribbling)

        when(intent.getIntExtra("dia", 1)){

            1 -> {
                exercisesList.add(DataModel(getString(R.string.Tex10),getString(R.string.Dex10), getString(R.string.Rex10) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex11),getString(R.string.Dex11) , getString(R.string.Rex11) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex12), getString(R.string.Dex12) , getString(R.string.Rex12) , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Puentes", "Voy de punta a punta de la cancha pasando la pelota entre las piernas", "2 series de punta a punta de la cancha" , R.drawable.placeholdergif))
            }
            2 -> {
                exercisesList.add(DataModel(getString(R.string.Tex14),getString(R.string.Dex14), getString(R.string.Rex14) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex15), getString(R.string.Dex15) , getString(R.string.Rex15) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex16), getString(R.string.Dex16), getString(R.string.Rex16) , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Detras de la esaplda", "Voy de punta a punta de la cancha cambiando la dirección detrás de la esaplda", "2 series de punta  a punta de la cancha" , R.drawable.placeholdergif))
            }
            3 -> {
                exercisesList.add(DataModel("Crossover", "", "" , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex13), getString(R.string.Dex13) , getString(R.string.Rex13) , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.Tex17), getString(R.string.Dex17) , getString(R.string.Rex17) , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Spin", "Voy de punta a punta de la cancha haciendo spins", getString(R.string.Rex16) , R.drawable.placeholdergif))
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
        actionbar!!.title = getString(R.string.dribbling)
        actionbar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}