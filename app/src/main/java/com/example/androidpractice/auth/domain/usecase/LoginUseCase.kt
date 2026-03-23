package com.example.androidpractice.auth.domain.usecase

import com.example.androidpractice.auth.domain.repository.AuthRepository

class LoginUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(
        login: String,
        password: String
    ): Boolean {

        // базовая валидация
        if (login.isBlank() || password.isBlank()) {
            return false
        }

        return repository.login(login, password)
    }
}