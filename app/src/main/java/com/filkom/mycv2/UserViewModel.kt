package com.filkom.mycv2

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.filkom.mycv2.data.UserData

class UserViewModel : ViewModel() {

    private val _userData = mutableStateOf<UserData?>(null)
    val userData get() = _userData.value

    fun login(email: String, password: String): Boolean {
        val currentUser = _userData.value
        return if (currentUser != null &&
            currentUser.email == email &&
            currentUser.password == password
        ) {
            true
        } else {
            false
        }
    }

    fun daftar(data: UserData) {
        _userData.value = data
    }
}
