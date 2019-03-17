package kz.epamlibrary.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import kz.epamlibrary.R
import kz.epamlibrary.explore.ExploreFragment
import kz.epamlibrary.notifications.NotificationsFragment
import kz.epamlibrary.profile.ProfileFragment

class HomeActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_notifications -> {
                showNotificationsFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_explore -> {
                showExploreFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                showProfileFragment()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        lateinit var intent: Intent
        val pref = getPreferences(Context.MODE_PRIVATE)
        val isLoggedIn = pref.getBoolean("isLoggedIn", false)

        if (!isLoggedIn) {
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        } else {
            showExploreFragment()
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
            navigation.selectedItemId = R.id.navigation_explore
        }
    }

    private fun showNotificationsFragment() {
        replaceFragment(NotificationsFragment())
    }

    private fun showExploreFragment() {
        replaceFragment(ExploreFragment())
    }

    private fun showProfileFragment() {
        replaceFragment(ProfileFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}
