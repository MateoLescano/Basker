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

                exercisesList.add(DataModel("Giro de poste basico","Me paro de dribbleando de espaldas al aro (posición de poste) dentro de la pintura. Me acerco al aro, y con pie de pivot hago una bandeja", "10 tiros por lado" , R.drawable.gifpost1d1))
                exercisesList.add(DataModel("Gancho fijo","Me paro enfrente del aro, en paralelo al tablero. Tiro un gancho con el brazo más alejado del aro concentrandome en hacer un giro amplio", "12 ganchos por lado" , R.drawable.gifpost1d2))
                exercisesList.add(DataModel("Post fadeaway","En posición de poste, me acerco al aro, me doy vuelta y tiro a distancia", "5 tiros encestados desde 4 lugares distintos" , R.drawable.gifpost1d3))
                exercisesList.add(DataModel("Putbacks","Tiro la pelota contra el tablero para simular un tiro fallado, agarro el rebote e instantaneamente tiro. Idealmente llego a tirar antes de tocar el piso.", "2 series de 10 tiros" , R.drawable.gifpost1d4))

            }
            2 -> {
                exercisesList.add(DataModel("Mikan Drill","Desde abajo del aro, doy un paso con la pierna izquierda hacía la derecha y en el mismo movimiento con hago una bandeja de mano derecha. Agarro la pelota apenas puedo y hago el movimiento inverso hacía la izquierda, y así sucesivamente.", "3 series de 10 bandejas seguidas" , R.drawable.gifpost2d1))
                exercisesList.add(DataModel("Gancho simple","Entro a la pintura en paralelo al tablero y tiro un gancho. Me concentro en dar los pasos correctos y en que la pelota no baje de la altura del hombro.", "12 ganchos por lado" , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Hesi fadeaway","En posición de poste dentro de la pintura, finto para un lado, para el otro, y me doy vuelta para tirar a distancia. Puedo hacerlo con salto en diagonal hacía atrás (fadeaway)", "5 tiros encestados desde 4 lugares distintos" , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Up and under","En posición de poste, me acerco al aro, me doy vuelta y hago un amague de tiro, y con el pie de pivot doy un paso para hacer una bandeja hacía el otro lado", "10 por lado" , R.drawable.placeholdergif))
            }
            3 -> {
                exercisesList.add(DataModel("Rondo","Corro hacía el aro como para hacer una bandeja, pero freno el movimiento extendiendo el brazo antes de tirar, y me doy vuelta para tirar", "10 por lado" , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Gancho con giro","Me paro de espaldas al aro sobre la linea de la pintura. Me doy vuelta hacía afuera,hago un pique y tiro un gancho. Me concentro en dar los pasos correctos y en que la pelota no baje de la altura del hombro", "2 series de 12 ganchos por lado" , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Putback Up and under ","Tiro la pelota contra el tablero para simular un tiro fallado, agarro el rebote, hago un amague de tiro, y con el pie de pivot doy un paso para hacer una bandeja hacía el otro lado", "2 series de 12 tiros" , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Spin fadeaway","En posición de poste, giro encarando hacía el aro, doy el primer paso como en un eurostep, pero cambio de dirección hacía atrás en el segundo y tiro alejandome del aro", "15 tiros encestados" , R.drawable.placeholdergif))
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