package com.citesoftware.basker.categorias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.citesoftware.basker.R

class FinishingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finishing)

        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.finishing)
        actionbar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}