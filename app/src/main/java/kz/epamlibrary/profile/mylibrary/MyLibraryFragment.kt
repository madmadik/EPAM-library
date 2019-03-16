package kz.epamlibrary.profile.mylibrary

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_my_library.view.*
import kz.epamlibrary.R
import kz.epamlibrary.adapter.BooksAdapter
import kz.epamlibrary.entity.Book

class MyLibraryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerView.Adapter<*>
    private var books = ArrayList<Book>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_my_library, container, false)

        initBooks()

        recyclerView = view.my_library_recycler_view

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = BooksAdapter(books)
        }

        return view
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
