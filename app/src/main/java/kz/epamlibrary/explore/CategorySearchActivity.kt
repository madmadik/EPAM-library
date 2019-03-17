package kz.epamlibrary.explore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_category_search.*
import kz.epamlibrary.R
import kz.epamlibrary.adapter.BooksAdapter
import kz.epamlibrary.app.AppController
import kz.epamlibrary.entity.Book
import kz.epamlibrary.network.Constant.CATEGORY_ID
import kz.epamlibrary.network.Constant.CATEGORY_NAME

class CategorySearchActivity : AppCompatActivity() {

    private var books = ArrayList<Book>()
    private var compositeDisposable = CompositeDisposable()
    private var id = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_search)

        back.setOnClickListener {
            onBackPressed()
        }

        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(query: String): Boolean {
                searchForBook(query)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {

                return false
            }

        })

        id = intent.getIntExtra(CATEGORY_ID, 0)
        val title = intent.getStringExtra(CATEGORY_NAME)

        toolbar_title.text = title

        fetchBooksByCategory()
    }

    private fun fetchBooksByCategory() {
        val appController = AppController.create(this)
        val usersService = appController.userService

        val disposable = usersService.fetchBooksByCategory(id)
            .subscribeOn(appController.subscribeScheduler())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                books = response as ArrayList<Book>
                Log.d("yeltayev22", books.size.toString())

                category_books_recycler_view.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = BooksAdapter(books)
                }
            }, {
                Log.d("yeltayev22", it.toString())
            })

        compositeDisposable.add(disposable)
    }

    private fun searchForBook(query: String) {
        val appController = AppController.create(this)
        val usersService = appController.userService

        val disposable = usersService.searchForBook(query)
            .subscribeOn(appController.subscribeScheduler())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                books = response as ArrayList<Book>
                Log.d("yeltayev22", books.size.toString())

                category_books_recycler_view.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = BooksAdapter(books)
                }
            }, {
                Log.d("yeltayev22", it.toString())
            })

        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
