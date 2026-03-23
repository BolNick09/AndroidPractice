package com.example.androidpractice.auth.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: UserEntity)

    @Query("SELECT * FROM users WHERE login = :login LIMIT 1")
    suspend fun getUserByLogin(login: String): UserEntity?

    @Query("SELECT * FROM users WHERE login = :login AND password = :password LIMIT 1")
    suspend fun auth(login: String, password: String): UserEntity?
}