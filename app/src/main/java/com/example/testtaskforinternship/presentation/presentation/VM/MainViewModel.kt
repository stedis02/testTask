package com.example.testtaskforinternship.presentation.presentation.VM

import androidx.lifecycle.ViewModel
import com.example.testtaskforinternship.presentation.domain.model.UserNameParam
import com.example.testtaskforinternship.presentation.domain.model.Userdata
import com.example.testtaskforinternship.presentation.domain.usecase.GetUserFirstNameUseCase
import com.example.testtaskforinternship.presentation.domain.usecase.SaveUserNameUseCase

class MainViewModel(private val getUserFirstNameUseCase: GetUserFirstNameUseCase) : ViewModel() {

    fun sayHello(): String {
        return "Привет, ${getUserFirstNameUseCase.execute()}!"
    }


}