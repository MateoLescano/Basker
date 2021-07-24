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
                exercisesList.add(DataModel("Bandeja ambidiestra","Hago bandejas comunes en diagonal al aro desde ambos lados, concentrandome en los pasos previos y su orden (primero pie derecho y luego izquierdo para bandeja de mano derecha y viceversa para izquierda).", "15 bandejas por lado" , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Bandejas bajo el aro","Me paro debajo del aro, mirando hacía el otro aro. Sin mover los pies, hago bandejas con tablero, sin tablero", "10 bandejas de cada tipo" , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Gancho fijo","Me paro enfrente del aro, en paralelo al tablero. Tiro un gancho con el brazo más alejado del aro concentrandome en hacer un giro amplio", "12 ganchos por lado" , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Bandeja reversa","Empiezo desde fuera de la pintura en paralelo al tablero, y defino con una bandeja pasada de reversa", "12 por lado" , R.drawable.placeholdergif))
            }
            2 -> {
                exercisesList.add(DataModel("Mikan Drill","Desde abajo del aro, doy un paso con la pierna izquierda hacía la derecha y en el mismo movimiento con hago una bandeja de mano derecha. Agarro la pelota apenas puedo y hago el movimiento inverso hacía la izquierda, y así sucesivamente.", "3 series de 10 bandejas seguidas" , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Stop and go","Empiezo dribleando desde fuera de la pintura. Entro con velocidad, me detengo sin dejar de driblear y ataco el aro con bandeja normal, eurostep o flotadora.", "2 series de 15" , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Gancho simple","Entro a la pintura en paralelo al tablero y tiro un gancho. Me concentro en dar los pasos correctos y en que la pelota no baje de la altura del hombro.", "12 ganchos por lado" , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Euro Step","Empiezo dribleando desde fuera de la pintura  y hago un eurostep. Hago eurostep para maximizar la distancia (manteniendo el lado del aro que estoy atacando) y para cambiar de dirección en el segundo paso (para tirar de frente o con bandeja reversa)", "15 euro steps por lado" , R.drawable.placeholdergif))
            }
            3 -> {
                exercisesList.add(DataModel("Bandeja con finta","Hago bandejas comunes en diagonal al aro desde ambos lados, pero mientras doy el primer paso hago una finta (amague de pase, movimiento circular, cambio de mano por detras de la espalda)", "15 bandejas por lado" , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Hop step","Empiezo dribbleando en dirección al aro, salgo y caigo con los dos pies juntos, y tiro al aro. Puede ser de frente o con cambio de dirección", "15 hop steps" , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Gancho con giro","Me paro de espaldas al aro sobre la linea de la pintura. Me doy vuelta hacía afuera,hago un pique y tiro un gancho. Me concentro en dar los pasos correctos y en que la pelota no baje de la altura del hombro", "2 series de 12 ganchos por lado" , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Flotadora simple","Empiezo dribleando desde fuera de la pintura, entro en diagonal y defino con una flotadora. Me concentro en dar los pasos correctos, en extenderme completamente y en mantener la pose después de tirar", "15 flotadoras por lado." , R.drawable.placeholdergif))
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