package kz.epamlibrary.base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.view.View
import kz.epamlibrary.R

class RegisterActivity : AppCompatActivity() {

    private lateinit var phone: TextInputEditText
    private lateinit var fullName: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var repeatPassword: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        phone = findViewById(R.id.phone)
        fullName = findViewById(R.id.fullName)
        password = findViewById(R.id.password)
        repeatPassword = findViewById(R.id.repeatPassword)
    }

    fun register(view: View) {
        if (!phone.text.isNullOrEmpty() && !fullName.text.isNullOrEmpty() && !password.text.isNullOrEmpty() && !repeatPassword.text.isNullOrEmpty() && (password.text.toString().length < 8 || repeatPassword.text.toString().length < 8) && (password.text.toString() == repeatPassword.text.toString())) {
            signUp()
        } else {
            if (phone.text.isNullOrEmpty()) {
                phone.error = "Введите номер телефона!"
            }

            if (fullName.text.isNullOrEmpty()) {
                fullName.error = "Введите ваше имя!"
            }

            if (password.text.isNullOrEmpty()) {
                password.error = "Введите ваш пароль!"
            } else {
                if (repeatPassword.text.isNullOrEmpty()) {
                    repeatPassword.error = "Пароли не совпадают!"
                } else if (password.text.toString().length < 8) {
                    password.error = "Минимум 8 символов!"
                } else if (repeatPassword.text.toString().length < 8) {
                    repeatPassword.error = "Минимум 8 символов!"
                } else if (password.text.toString() != repeatPassword.text.toString()) {
                    password.error = "Пароли не совпадают!"
                    repeatPassword.error = "Пароли не совпадают!"
                }
            }
        }
    }

    private fun signUp() {

    }
}
