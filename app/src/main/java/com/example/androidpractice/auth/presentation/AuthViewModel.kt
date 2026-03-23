package com.example.androidpractice.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidpractice.auth.domain.usecase.LoginUseCase
import com.example.androidpractice.auth.domain.usecase.RegisterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun onLoginClick(login: String, password: String) {

        if (!validate(login, password)) return

        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(isLoading = true)

            try {
                val success = loginUseCase(login, password)

                if (success) {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        isSuccess = true
                    )
                } else {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = "Неверный логин или пароль"
                    )
                }

            } catch (e: Exception) {

                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Ошибка авторизации"
                )
            }
        }
    }

    fun onRegisterClick(login: String, password: String) {

        if (!validate(login, password)) return

        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(isLoading = true)

            try {
                val success = registerUseCase(login, password)

                if (success) {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        isSuccess = true
                    )
                } else {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = "Пользователь уже существует"
                    )
                }

            } catch (e: Exception) {

                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Ошибка регистрации"
                )
            }
        }
    }

    private fun validate(login: String, password: String): Boolean {

        return when {
            login.isBlank() -> {
                _uiState.value = _uiState.value.copy(error = "Введите логин")
                false
            }
            password.isBlank() -> {
                _uiState.value = _uiState.value.copy(error = "Введите пароль")
                false
            }
            password.length < 4 -> {
                _uiState.value = _uiState.value.copy(error = "Пароль слишком короткий")
                false
            }
            else -> true
        }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}