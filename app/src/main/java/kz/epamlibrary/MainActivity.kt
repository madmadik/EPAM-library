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

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")


        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                Log.d("YELTAYEV22", "Value is: " + value!!)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("YELTAYEV22", "Failed to read value.", error.toException())
            }
        })

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
