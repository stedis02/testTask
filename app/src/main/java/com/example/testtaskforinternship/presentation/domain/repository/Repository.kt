package com.example.testtaskforinternship.presentation.domain.repository

import com.example.testtaskforinternship.presentation.domain.model.UserNameParam
import com.example.testtaskforinternship.presentation.domain.model.Userdata

interface Repository {
    fun getUserName(): UserNameParam
    fun saveUserName(userData: Userdata): Boolean
}
