package com.example.unittestpracticing.utils

class PasswordHelper {

    fun isValidPassword(password: String?): Boolean {
        return when {
            password.isNullOrBlank() -> false
            password.length < 6 || password.length > 15 -> false
            else -> true
        }
    }
}