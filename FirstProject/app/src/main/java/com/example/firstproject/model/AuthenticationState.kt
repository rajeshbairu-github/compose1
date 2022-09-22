package com.example.firstproject.model

data class AuthenticationState(val authenticationMode: AuthenticationMode = AuthenticationMode.SIGN_OUT,
                            val email: String? = null,
                          val password: String? = null) {
}