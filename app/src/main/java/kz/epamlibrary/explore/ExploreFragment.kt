package kz.epamlibrary.explore

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_explore.view.*
import kz.epamlibrary.R
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

        fetchBooks()

        return view
    }

    private fun fetchBooks() {
        val appController = AppController.create(activity)
        val usersService = appController.userService

        val disposable = usersService.fetchBooks()
            .subscribeOn(appController.subscribeScheduler())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                books = response as ArrayList<Book>
            }, {
            })

        compositeDisposable.add(disposable)
    }
}