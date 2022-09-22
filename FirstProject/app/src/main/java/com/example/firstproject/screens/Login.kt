package com.example.firstproject.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firstproject.LoginViewModel

@Composable
fun Login()
{
    val viewModel: LoginViewModel = viewModel()

    MaterialTheme {
        LoginScreen(
            //authenticate = viewModel::authenticate
            state = viewModel.uiState.collectAsState().value,
            handleEvent = viewModel::handleEvent,
            authenticate = viewModel::authenticate
        )
    }
}