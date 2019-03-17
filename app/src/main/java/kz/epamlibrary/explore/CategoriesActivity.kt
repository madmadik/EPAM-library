package kz.epamlibrary.explore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.activity_my_library.*
import kz.epamlibrary.R
import kz.epamlibrary.adapter.BooksAdapter
import kz.epamlibrary.adapter.CategoriesAdapter
import kz.epamlibrary.app.AppController
import kz.epamlibrary.entity.Book
import kz.epamlibrary.entity.Category

class CategoriesActivity : AppCompatActivity() {

    private var categories = ArrayList<Category>()
    private var compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        fetchCategories()

        back_category.setOnClickListener {
            onBackPressed()
        }
    }

    private fun fetchCategories() {
        val appController = AppController.create(this)
        val usersService = appController.userService

        val disposable = usersService.fetchCategories()
            .subscribeOn(appController.subscribeScheduler())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                categories = response as ArrayList<Category>
                Log.d("yeltayev22", categories.size.toString())

                categories_recycler_view.apply {
                    setHasFixedSize(true)
                    layoutManager = GridLayoutManager(context, 4)
                    adapter = CategoriesAdapter(categories)
                }

            }, {
                Log.d("yeltayev22", it.toString())
            })

        compositeDisposable.add(disposable)
    }
}
