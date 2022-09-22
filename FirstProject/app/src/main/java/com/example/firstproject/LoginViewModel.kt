package com.example.firstproject

import androidx.lifecycle.ViewModel
import com.example.firstproject.model.AuthenticationEvent
import com.example.firstproject.model.AuthenticationMode
import com.example.firstproject.model.AuthenticationState
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel : ViewModel() {

    val uiState = MutableStateFlow(AuthenticationState())

    fun handleEvent(authenticationEvent: AuthenticationEvent) {
        when (authenticationEvent) {
          //  AuthenticationEvent.ToggleAuthenticationMode -> toggleAuthenticationMode()
            is AuthenticationEvent.EmailChanged -> {
                updateEmail(authenticationEvent.emailAddress)
            }
            is AuthenticationEvent.PasswordChanged -> {
                updatePassword(authenticationEvent.password)
            }
        }
    }

    fun authenticate()
    {
        val name:String=uiState.value.email.toString()
        val password:String=uiState.value.password.toString()

        if((name == "Rajesh") and (password == "123456"))
        {
            uiState.value = uiState.value.copy(authenticationMode =   AuthenticationMode.SIGN_OUT)
        }else
        {
            uiState.value = uiState.value.copy(authenticationMode =   AuthenticationMode.SIGN_IN)

        }


    }

    private fun updateEmail(email: String) {
        uiState.value = uiState.value.copy(email = email)
    }

    private fun updatePassword(password : String)
    {
        uiState.value = uiState.value.copy(password = password)
    }



}