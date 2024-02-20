package com.example.applogincompose.util

fun validateEmail(email: String): Boolean {
    val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")

    return when {
        email.isEmpty() -> {
            // Email is empty
            false
        }
        !emailRegex.matches(email) -> {
            // Email format is invalid
            false
        }
        else -> {
            // Email is valid
            true
        }
    }
}

fun validatePassword(password: String): Boolean {
    val minLength = 8
    val maxLength = 25

    val hasUppercase = password.any { it.isUpperCase() }
    val hasNumber = password.any { it.isDigit() }

    return password.length in minLength..maxLength && hasUppercase && hasNumber
}