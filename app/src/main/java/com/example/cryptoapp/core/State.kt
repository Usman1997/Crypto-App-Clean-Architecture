package com.example.cryptoapp.core

sealed class State<T>(val data: T? = null, val message: String? = null) {

    class Success<T>(data: T) : State<T>(data = data)
    class Error<T>(data: T? = null, message: String) : State<T>(data = data, message = message)
    class Loading<T>(data: T? = null) : State<T>(data = data)
}