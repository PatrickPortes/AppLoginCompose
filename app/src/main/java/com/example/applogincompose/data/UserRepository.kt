package com.example.applogincompose.data

class UserRepository(private val dao: UserDao) {

    val users = dao.getAllUsers()

    suspend fun addUser(user: User): Long{
        return dao.insertUser(user)
    }

    suspend fun update(user: User): Int{
        return dao.updateUser(user)
    }

    suspend fun delete(user: User): Int{
        return dao.deleteUser(user)
    }

    suspend fun deleteAll(): Int{
        return dao.deleteAll()
    }

}