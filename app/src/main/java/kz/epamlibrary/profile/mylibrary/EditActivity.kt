package kz.epamlibrary.profile.mylibrary

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_edit.*
import kz.epamlibrary.R
import kz.epamlibrary.app.AppController
import kz.epamlibrary.entity.Category
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.AdapterView.OnItemSelectedListener
import kz.epamlibrary.entity.Book


class EditActivity : AppCompatActivity() {

    private var categories = ArrayList<Category>()
    private var compositeDisposable = CompositeDisposable()
    private lateinit var categoryAdapter: ArrayAdapter<String>

    private var categoryId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        fetchCategories()

        edit_back.setOnClickListener {
            onBackPressed()
        }

        done.setOnClickListener {
            val book = Book(
                edit_author.text.toString(),
                listOf(categories.get(categoryId)),
                null,
                null,
                edit_description.text.toString(),
                null,
                null,
                edit_title.text.toString()
                )
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

                val categoryNames = mutableListOf<String>()
                for (category in categories) {
                    categoryNames.add(category.name)
                }
                categoryAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoryNames)
                categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                edit_category.apply {
                    adapter = categoryAdapter
                    prompt = "Category"
                }

                edit_category.onItemSelectedListener = object : OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>, view: View,
                        position: Int, id: Long
                    ) {
                        categoryId = position
                        // показываем позиция нажатого элемента
                        Toast.makeText(baseContext, "Position = $position", Toast.LENGTH_SHORT).show()
                    }

                    override fun onNothingSelected(arg0: AdapterView<*>) {}
                }

            }, {
                Log.d("yeltayev22", it.toString())
            })

        compositeDisposable.add(disposable)
    }
}
