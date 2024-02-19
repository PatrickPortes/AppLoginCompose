package com.example.applogincompose.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User): Long

    @Update
    suspend fun updateUser(user: User): Int

    @Delete
    suspend fun deleteUser(user: User): Int

    @Query("DELETE FROM user_data_table")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM user_data_table")
    fun getAllUsers(): LiveData<List<User>>

}