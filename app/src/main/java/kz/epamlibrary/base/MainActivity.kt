package kz.epamlibrary.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kz.epamlibrary.R

class MainActivity : AppCompatActivity() {

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
}
