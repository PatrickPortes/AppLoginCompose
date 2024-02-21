package com.example.applogincompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applogincompose.data.Repository
import com.example.applogincompose.data.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    fun insertUser(user: User) {
        viewModelScope.launch(IO) {
            repository.insert(user)
        }
    }

    // Function to authenticate user
    suspend fun authenticateUser(email: String, password: String): Boolean {
        val user = repository.getUserByEmailAndPassword(email, password)
        return user != null
    }

}