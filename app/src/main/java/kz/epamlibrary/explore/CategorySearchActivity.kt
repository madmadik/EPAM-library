package kz.epamlibrary.explore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_category_search.*
import kz.epamlibrary.R
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

            }, {
                Log.d("yeltayev22", it.toString())
            })

        compositeDisposable.add(disposable)
    }
}
