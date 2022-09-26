package com.example.testtaskforinternship.presentation.presentation.VM

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.testtaskforinternship.presentation.domain.model.Userdata
import com.example.testtaskforinternship.presentation.domain.usecase.SaveUserNameUseCase

class AuthorizationViewModel(private val saveUserNameUseCase: SaveUserNameUseCase) : ViewModel() {

    fun save(userdata: Userdata): Boolean {
        return saveUserNameUseCase.execute(userdata)
    }


    fun checkName(name: String): Boolean {
        val regex = Regex("^[a-zA-Zа-яА-Я]+\$")
        return name.split(' ')
            .all {
                it.isNotEmpty() && it[0].isUpperCase()
                        && regex.matches(it)
                        && it.length >= 2
            }
                && name.split(' ').size == 1

    }

    fun checkDate(date: String): Boolean {
        val regex =
            Regex("^(?:(?:31(\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})\$|^(?:29(\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))\$|^(?:0?[1-9]|1\\d|2[0-8])(\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})\$")
        return regex.matches(date)
    }


    fun checkPasswordValidity(password: String): Boolean {
        return Regex("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}").matches(password)
    }


}