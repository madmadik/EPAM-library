package kz.epamlibrary.base

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.view.View
import kz.epamlibrary.R

class LoginActivity : AppCompatActivity() {

    private lateinit var phone: TextInputEditText
    private lateinit var password: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        phone = findViewById(R.id.phone)
        password = findViewById(R.id.password)
    }

    fun signIn(view: View) {
        if (!phone.text.isNullOrEmpty() && !password.text.isNullOrEmpty()) {
            signIn()
        } else {
            if (phone.text.isNullOrEmpty()) {
                phone.error = "Введите номер телефона!"
            }
            if (password.text.isNullOrEmpty()) {
                password.error = "Введите ваш пароль!"
            }
        }
    }

    private fun signIn() {

    }

    fun registerClick(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}
