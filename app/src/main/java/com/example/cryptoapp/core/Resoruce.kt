package com.example.cryptoapp.core

sealed class Resoruce<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resoruce<T>(data)
    class Error<T>(message: String, data: T? = null) : Resoruce<T>(data, message)
    class Loading<T>(data: T? = null) : Resoruce<T>(data)
}