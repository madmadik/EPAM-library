package kz.epamlibrary.profile.mylibrary

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_my_library.*
import kz.epamlibrary.R
import kz.epamlibrary.adapter.BooksAdapter
import kz.epamlibrary.entity.Book

class MyLibraryActivity : AppCompatActivity() {

    private var books = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_library)

        initBooks()

        my_library_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = BooksAdapter(books)
        }

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

    private fun initBooks() {
        books.add(Book("The world of abstract art", "Emily Braun", "Nurda Yeltayev", "Design", "4.5"))
        books.add(Book("The world of abstract art", "Emily Braun", "Nurda Yeltayev", "Design", "4.5"))
        books.add(Book("The world of abstract art", "Emily Braun", "Nurda Yeltayev", "Design", "4.5"))
        books.add(Book("The world of abstract art", "Emily Braun", "Nurda Yeltayev", "Design", "4.5"))
        books.add(Book("The world of abstract art", "Emily Braun", "Nurda Yeltayev", "Design", "4.5"))
        books.add(Book("The world of abstract art", "Emily Braun", "Nurda Yeltayev", "Design", "4.5"))
        books.add(Book("The world of abstract art", "Emily Braun", "Nurda Yeltayev", "Design", "4.5"))
        books.add(Book("The world of abstract art", "Emily Braun", "Nurda Yeltayev", "Design", "4.5"))
        books.add(Book("The world of abstract art", "Emily Braun", "Nurda Yeltayev", "Design", "4.5"))
    }
}
