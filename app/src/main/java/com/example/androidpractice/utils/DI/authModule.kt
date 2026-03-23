package com.example.androidpractice.utils.DI

import androidx.room.Room
import com.example.androidpractice.auth.data.local.AppDatabase
import com.example.androidpractice.auth.data.repository.AuthRepositoryImpl
import com.example.androidpractice.auth.domain.repository.AuthRepository
import com.example.androidpractice.auth.domain.usecase.LoginUseCase
import com.example.androidpractice.auth.domain.usecase.RegisterUseCase
import com.example.androidpractice.auth.presentation.AuthViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val authModule = module {

    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "app_db"
        ).build()
    }

    single<AuthRepository> {
        AuthRepositoryImpl(get())
    }

    single { get<AppDatabase>().userDao() }
    single { LoginUseCase(get()) }
    single { RegisterUseCase(get()) }

    viewModel {
        AuthViewModel(
            loginUseCase = get(),
            registerUseCase = get()
        )
    }
}


