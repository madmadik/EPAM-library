package kz.epamlibrary.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import kz.epamlibrary.R
import kz.epamlibrary.app.AppController
import kz.epamlibrary.network.Constant.RANDOM_USER_URL

class MainActivity : AppCompatActivity() {

    private var compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fetchUsersList()


        lateinit var intent: Intent
        val pref = getPreferences(Context.MODE_PRIVATE)
        val isLoggedIn = pref.getBoolean("isLoggedIn", false)

        intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("id", pref.getInt("id", 0))
        /*if (!isLoggedIn) {
            intent = Intent(this, LoginActivity::class.java)
        } else {
            intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("id", pref.getInt("id", 0))
        }*/

        startActivity(intent)

    }

    private fun fetchUsersList() {
        val appController = AppController.create(this)
        val usersService = appController.userService

        val disposable = usersService.fetchUsers(RANDOM_USER_URL)
            .subscribeOn(appController.subscribeScheduler())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ userResponse ->
                text.text = userResponse.peopleList?.get(0)?.gender
            }, {

            })

        compositeDisposable.add(disposable)
    }

    /// Implement onDestroy disposable
}
