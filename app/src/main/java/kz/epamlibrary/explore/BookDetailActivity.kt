package kz.epamlibrary.explore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_book_detail.*
import kz.epamlibrary.R

class BookDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        back.setOnClickListener {
            onBackPressed()
        }
    }
}
