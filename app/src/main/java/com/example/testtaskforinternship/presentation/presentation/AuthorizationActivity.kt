package com.example.testtaskforinternship.presentation.presentation

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.os.Bundle
import android.text.format.DateUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.testtaskforinternship.R
import com.example.testtaskforinternship.presentation.domain.model.Userdata
import com.example.testtaskforinternship.presentation.presentation.VM.AuthorizationViewModel
import com.example.testtaskforinternship.presentation.presentation.VM.AuthorizationViewModelFactory
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class AuthorizationActivity : AppCompatActivity() {
    private lateinit var authorizationViewModel: AuthorizationViewModel
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var date: EditText
    private lateinit var password: EditText
    private lateinit var checkPassword: EditText
    private lateinit var textError: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
        authorizationViewModel = ViewModelProvider(
            this,
            AuthorizationViewModelFactory(this)
        ).get(AuthorizationViewModel::class.java)
        firstName = findViewById(R.id.firstName)
        lastName = findViewById(R.id.lastName)
        date = findViewById(R.id.date)
        password = findViewById(R.id.Password)
        checkPassword = findViewById(R.id.checkPassword)
        textError = findViewById(R.id.textError)

    }


    fun authorization(view: View) {
        if (checkValues()) {

            if (authorizationViewModel
                    .save(
                        Userdata(
                            firstName.text.toString(),
                            lastName.text.toString(),
                            date.text.toString(),
                            password.text.toString()
                        )
                    )
            ) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }


    @SuppressLint("SetTextI18n")
    private fun checkValues(): Boolean {
        if (firstName.text.isEmpty() || lastName.text.isEmpty() || date.text.isEmpty() || password.text.isEmpty() || checkPassword.text.isEmpty()) {
            Toast.makeText(this, "заполните все поля!", Toast.LENGTH_SHORT).show()
            return false
        } else if (!authorizationViewModel.checkName(firstName.text.toString())) {
            textError.text =
                "* Неверный формат имени! \n Имя должно начинаться с заглавной буквы, содержать минимум 2 буквы"
            return false
        } else if (!authorizationViewModel.checkName(lastName.text.toString())) {
            textError.text =
                "* Неверный формат фамилии! \n Фамилия должна начинаться с заглавной буквы, содержать минимум 2 буквы"
            return false
        } else if (!authorizationViewModel.checkDate(date.text.toString())) {
            Toast.makeText(this, "Неверный формат даты!", Toast.LENGTH_SHORT).show()
            return false
        } else if (!authorizationViewModel.checkPasswordValidity(password.text.toString())) {
            textError.text =
                "* пароль должен содержать хотя бы одну латинскую букву в нижнем и в верхнем регистре, содержать хотя бы 1 цифру, быть не короче 8 символов"
            return false
        } else if (password.text.toString().length != checkPassword.text.toString().length) {
            Toast.makeText(this, "введённые пароли не совпадают!", Toast.LENGTH_LONG).show()
            return false
        } else return true
    }


}