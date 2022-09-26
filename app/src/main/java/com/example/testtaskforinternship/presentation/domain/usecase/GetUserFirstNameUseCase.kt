package com.example.testtaskforinternship.presentation.domain.usecase

import com.example.testtaskforinternship.presentation.domain.repository.Repository

class GetUserFirstNameUseCase(private val repository: Repository) {
    fun execute(): String {
        return repository.getUserName().firstName
    }
}