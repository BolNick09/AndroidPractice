package com.example.androidpractice.auth.domain.usecase

import com.example.androidpractice.auth.domain.repository.AuthRepository

class RegisterUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(
        login: String,
        password: String
    ): Boolean {

        // базовая валидация на уровне domain
        if (login.isBlank() || password.isBlank()) {
            return false
        }

        if (password.length < 4) {
            return false
        }

        return repository.register(login, password)
    }
}