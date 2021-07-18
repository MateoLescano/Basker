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
                exercisesList.add(DataModel("Dribble en V Frontal","Con los pies abiertos al ancho de los hombros, las rodillas flexionadas y mirando al frente, dribbleo de lado a lado frontalmente. Aumento la velocidad Y fuerza tanto como pueda.", "3 series de 20 dribbles por cada mano." , R.drawable.placeholdergif))
                exercisesList.add(DataModel("8's","Con postura baja, dribbleo lo más cerca al piso que pueda en forma de 8 entre las piernas. Aumento la velocidad Y fuerza tanto como pueda." , "10 vueltas completas en una dirrección y 10 más en la otra." , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Dribble con sprint", "De punta a punta de la cancha, dribbleo en velocidad, freno, cambio la mano del dribble, y vuelvo a acelerar. Nunca paro de dribblear y aumento la velocidad tanto como pueda." , "4 series de punta a punta de la cancha." , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Dribble entre conos", "Coloco conos/objetos en una linea recta. Dribbleo entre los conos (como en un examen de manejo) en zigzag, luego cambiando de manos, luego entre las piernas, y finalmente por detras de la espalda." , "2 series de punta a punta" , R.drawable.placeholdergif))

            }
            2 -> {
                exercisesList.add(DataModel("Dribble en V Lateral","Con los pies abiertos al ancho de los hombros, las rodillas flexionadas y mirando al frente, dribbleo de adelante hacía atrás lateralmente. Aumento la velocidad Y fuerza tanto como pueda.", "3 series de 20 dribbles por cada mano." , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Dribble entre conos dobles", "Coloco dos filas de conos/objetos en linea recta. Dribbleo entre los conos de una fila a la otra en zigzag, cambiando de manos, luego entre las piernas, y finalmente por detras de la espalda." , "2 series de punta a punta" , R.drawable.placeholdergif))
                exercisesList.add(DataModel("Dribble en cruz", "Con los pies abiertos al ancho de los hombros, las rodillas flexionadas y mirando al frente, dribbleo de izquierda a derecha en el frente, entre las piernas, de izquierda a derecha por la espalda, y nuevamente entre las piernas.", "10 series en una dirección y 10 en la otra." , R.drawable.placeholdergif))
                exercisesList.add(DataModel(getString(R.string.TFT), getString(R.string.DFT), getString(R.string.RFT1) , R.drawable.placeholdergif))

            }
            3 -> {
                exercisesList.add(DataModel("Dribbling estacionario", "Con los pies abiertos al ancho de los hombros, las rodillas flexionadas y mirando al frente, pico la pelota verticalmente aumentando la velocidad y la fuerza tanto como pueda." , "3 series de 60 segundos por mano." , R.drawable.placeholdergif))

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