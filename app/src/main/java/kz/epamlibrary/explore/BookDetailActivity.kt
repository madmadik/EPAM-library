package kz.epamlibrary.explore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_book_detail.*
import kz.epamlibrary.R
import kz.epamlibrary.app.AppController
import kz.epamlibrary.entity.Book
import kz.epamlibrary.network.Constant.BOOK_ID

class BookDetailActivity : AppCompatActivity() {

    private var id = 0
    private lateinit var book: Book
    private var compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        id = intent.getIntExtra(BOOK_ID, 0)

        fetchBookInfo()
        back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun fetchBookInfo() {
        val appController = AppController.create(this)
        val usersService = appController.userService

        val disposable = usersService.fetchBookInfo(id)
            .subscribeOn(appController.subscribeScheduler())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                book = response as Book
                Log.d("yeltayev22", book.author)

                author.text = book.author
                bookTitle.text = book.title
                category.text = book.categories[0].name
                description.text = book.description

            }, {
                Log.d("yeltayev22", it.toString())
            })

        compositeDisposable.add(disposable)
    }
}
