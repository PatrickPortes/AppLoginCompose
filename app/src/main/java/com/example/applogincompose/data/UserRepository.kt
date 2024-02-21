package com.example.applogincompose.data

interface Repository {

    suspend fun insert(user: User)

    suspend fun delete(user: User)

    suspend fun update(user: User)

    suspend fun getUserByEmailAndPassword(email: String, password: String): User?
}