package com.example.androidpractice.auth.data.repository

import com.example.androidpractice.auth.data.local.UserDao
import com.example.androidpractice.auth.data.local.UserEntity
import com.example.androidpractice.auth.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val userDao: UserDao
) : AuthRepository {

    override suspend fun register(login: String, password: String): Boolean {

        val existingUser = userDao.getUserByLogin(login)

        if (existingUser != null) {
            return false
        }

        userDao.insert(
            UserEntity(
                login = login,
                password = password
            )
        )

        return true
    }

    override suspend fun login(login: String, password: String): Boolean {

        return userDao.auth(login, password) != null
    }
}