package com.example.applogincompose.data

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dao: UserDao,
) : Repository {
    override suspend fun insert(user: User) {
        withContext(IO) {
            dao.insert(user)
        }
    }

    override suspend fun delete(user: User) {
        withContext(IO) {
            dao.delete(user)
        }
    }

    override suspend fun update(user: User) {
        withContext(IO) {
            dao.update(user)
        }
    }

    override suspend fun getUserByEmailAndPassword(email: String, password: String): User? {
        return withContext(IO){
            dao.getUserByEmailAndPassword(email, password)
        }
    }

}