package kz.epamlibrary.profile.mylibrary

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_my_library.*
import kz.epamlibrary.R

class MyLibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_library)

        add.setOnClickListener {
            openEditBook()
        }

        back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun openEditBook() {
        val intent = Intent(this, EditActivity::class.java)
        startActivity(intent)
    }


}
