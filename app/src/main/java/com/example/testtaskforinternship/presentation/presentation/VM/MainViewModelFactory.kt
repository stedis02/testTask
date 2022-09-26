package com.example.testtaskforinternship.presentation.presentation.VM

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testtaskforinternship.presentation.data.repository.RepositoryImp
import com.example.testtaskforinternship.presentation.domain.usecase.GetUserFirstNameUseCase
import com.example.testtaskforinternship.presentation.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val repositoryImp by lazy(LazyThreadSafetyMode.NONE) { RepositoryImp(context) }

    private val getUserFirstNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserFirstNameUseCase(
            repositoryImp
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserFirstNameUseCase) as T
    }
}