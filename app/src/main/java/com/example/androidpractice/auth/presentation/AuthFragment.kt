package com.example.androidpractice.auth.presentation

import android.os.Bundle
import android.view.View
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment : Fragment() {

    private val viewModel: AuthViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val composeView = view as ComposeView

        composeView.setContent {

            AuthScreen(
                viewModel = viewModel,
                onSuccess = {
                    findNavController().navigate(
                        com.example.androidpractice.R.id.action_authFragment_to_homeFragment
                    )
                }
            )
        }
    }

    override fun onCreateView(
        inflater: android.view.LayoutInflater,
        container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext())
    }
    @Composable
    fun AuthScreen(
        viewModel: AuthViewModel,
        onSuccess: () -> Unit
    ) {

        val state = viewModel.uiState.collectAsState()

        var login by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var isLoginMode by remember { mutableStateOf(true) }

        if (state.value.isSuccess) {
            onSuccess()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = if (isLoginMode) "Авторизация" else "Регистрация"
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = login,
                onValueChange = { login = it },
                label = { Text("Логин") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Пароль") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (isLoginMode) {
                        viewModel.onLoginClick(login, password)
                    } else {
                        viewModel.onRegisterClick(login, password)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (isLoginMode) "Войти" else "Зарегистрироваться")
            }

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(
                onClick = {
                    isLoginMode = !isLoginMode
                    viewModel.clearError()
                }
            ) {
                Text(
                    if (isLoginMode)
                        "Нет аккаунта? Регистрация"
                    else
                        "Есть аккаунт? Войти"
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            state.value.error?.let {
                Text(text = it, color = MaterialTheme.colorScheme.error)
            }

        }
    }
}

