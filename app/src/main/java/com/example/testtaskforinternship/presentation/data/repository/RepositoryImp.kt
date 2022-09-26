package com.example.testtaskforinternship.presentation.data.repository

import android.content.Context
import com.example.testtaskforinternship.presentation.domain.model.UserNameParam
import com.example.testtaskforinternship.presentation.domain.model.Userdata
import com.example.testtaskforinternship.presentation.domain.repository.Repository

private const val SHARED_PREFERENCES_NAME = "shared_preferences_name"
private const val FIRST_NAME_KAY = "first_name_key"
private const val LAST_NAME_KAY = "last_name_key"
private const val DEFAULT_NAME = "default_name"

class RepositoryImp(private val context: Context) : Repository {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)


    override fun getUserName(): UserNameParam {
        val firstName = sharedPreferences.getString(FIRST_NAME_KAY, DEFAULT_NAME) ?: DEFAULT_NAME
        val lastName = sharedPreferences.getString(LAST_NAME_KAY, DEFAULT_NAME) ?: DEFAULT_NAME
        return UserNameParam(firstName, lastName)
    }

    override fun saveUserName(userDate: Userdata): Boolean {
        return try {
            sharedPreferences.edit().putString(FIRST_NAME_KAY, userDate.firstName).apply()
            sharedPreferences.edit().putString(LAST_NAME_KAY, userDate.lastName).apply()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}