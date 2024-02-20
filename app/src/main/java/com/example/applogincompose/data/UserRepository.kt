package com.example.applogincompose.data

import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun insert(user: User)

    suspend fun delete(user: User)

    suspend fun update(user: User)

    suspend fun getAllUsers(): Flow<List<User>>
}