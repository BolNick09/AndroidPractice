package com.example.androidpractice.auth.domain.repository

interface AuthRepository {
    suspend fun login(login: String, password: String): Boolean
    suspend fun register(login: String, password: String): Boolean
}