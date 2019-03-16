package kz.epamlibrary

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var intent: Intent
        val pref = getPreferences(Context.MODE_PRIVATE)
        val isLoggedIn = pref.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            intent = Intent(this, LoginActivity::class.java)
        } else {
            intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("id", pref.getInt("id", 0))
        }

        startActivity(intent)

    }
}
