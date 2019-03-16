package kz.epamlibrary.explore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_categories.*
import kz.epamlibrary.R

class CategoriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        back.setOnClickListener {
            onBackPressed()
        }
    }
}
