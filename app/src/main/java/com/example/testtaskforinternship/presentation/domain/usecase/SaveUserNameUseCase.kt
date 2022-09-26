package com.example.testtaskforinternship.presentation.domain.usecase

import com.example.testtaskforinternship.presentation.domain.model.UserNameParam
import com.example.testtaskforinternship.presentation.domain.model.Userdata
import com.example.testtaskforinternship.presentation.domain.repository.Repository

class SaveUserNameUseCase(private val repository: Repository) {
    fun execute(userData: Userdata): Boolean {
        return repository.saveUserName(userData)
    }
}