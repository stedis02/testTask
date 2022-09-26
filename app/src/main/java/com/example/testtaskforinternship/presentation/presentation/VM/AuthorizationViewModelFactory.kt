package com.example.testtaskforinternship.presentation.presentation.VM

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testtaskforinternship.presentation.data.repository.RepositoryImp
import com.example.testtaskforinternship.presentation.domain.usecase.SaveUserNameUseCase

class AuthorizationViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val repositoryImp by lazy(LazyThreadSafetyMode.NONE) { RepositoryImp(context) }

    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            repositoryImp
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthorizationViewModel(saveUserNameUseCase) as T
    }
}