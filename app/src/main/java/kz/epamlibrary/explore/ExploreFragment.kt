package kz.epamlibrary.explore

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_explore.view.*
import kz.epamlibrary.R
import kz.epamlibrary.adapter.BooksAdapter
import kz.epamlibrary.app.AppController
import kz.epamlibrary.entity.Book
import kz.epamlibrary.network.Constant

class ExploreFragment : Fragment() {

    private var books = ArrayList<Book>()
    private var compositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_explore, container, false)

        view.categories_see_all.setOnClickListener {
            val intent = Intent(activity, CategoriesActivity::class.java)
            startActivity(intent)
        }

        view.books_search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(query: String): Boolean {
                searchForBook(query, view)
                if (query == "") {
                    view.explore_container.visibility = View.VISIBLE
                    view.books_recycler_view.visibility = View.GONE
                } else {
                    view.explore_container.visibility = View.GONE
                    view.books_recycler_view.visibility = View.VISIBLE
                }
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {

                return false
            }

        })

        view.arts.setOnClickListener {
            openArts()
        }

        view.bibliographies.setOnClickListener {
            openBibliographies()
        }

        view.business.setOnClickListener {
            openBusiness()
        }

        view.calendars.setOnClickListener {
            openCalendars()
        }

        view.cover_1.setOnClickListener {
            val intent = Intent(activity, BookDetailActivity::class.java)
            intent.putExtra(Constant.BOOK_ID, 345678)
            activity?.startActivity(intent)
        }

        view.cover_2.setOnClickListener {
            val intent = Intent(activity, BookDetailActivity::class.java)
            intent.putExtra(Constant.BOOK_ID, 112233)
            activity?.startActivity(intent)
        }

        view.cover_3.setOnClickListener {
            val intent = Intent(activity, BookDetailActivity::class.java)
            intent.putExtra(Constant.BOOK_ID, 345678)
            activity?.startActivity(intent)
        }

        return view
    }

    private fun searchForBook(query: String, view: View) {
        val appController = AppController.create(activity)
        val usersService = appController.userService

        val disposable = usersService.searchForBook(query)
            .subscribeOn(appController.subscribeScheduler())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                books = response as ArrayList<Book>
                Log.d("yeltayev22", books.size.toString())

                view.books_recycler_view.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = BooksAdapter(books)
                }
            }, {
                Log.d("yeltayev22", it.toString())
            })

        compositeDisposable.add(disposable)
    }

    fun openArts() {
        val intent = Intent(activity, CategorySearchActivity::class.java)
        intent.putExtra(Constant.CATEGORY_ID, "1")
        intent.putExtra(Constant.CATEGORY_NAME, "Arts")
        activity?.startActivity(intent)
    }

    fun openBibliographies() {
        val intent = Intent(activity, CategorySearchActivity::class.java)
        intent.putExtra(Constant.CATEGORY_ID, "2")
        intent.putExtra(Constant.CATEGORY_NAME, "Bibliographies")
        activity?.startActivity(intent)
    }

    fun openBusiness() {
        val intent = Intent(activity, CategorySearchActivity::class.java)
        intent.putExtra(Constant.CATEGORY_ID, "3")
        intent.putExtra(Constant.CATEGORY_NAME, "Business")
        activity?.startActivity(intent)
    }

    fun openCalendars() {
        val intent = Intent(activity, CategorySearchActivity::class.java)
        intent.putExtra(Constant.CATEGORY_ID, "4")
        intent.putExtra(Constant.CATEGORY_NAME, "Calendars")
        activity?.startActivity(intent)
    }
}