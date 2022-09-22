package com.example.firstproject.screens

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.firstproject.Home
import com.example.firstproject.model.AuthenticationEvent
import com.example.firstproject.model.AuthenticationMode
import com.example.firstproject.model.AuthenticationState
import com.example.firstproject.screens.theme.FirstProjectTheme

@Composable
fun LoginScreen(
    state: AuthenticationState,
    handleEvent: (event:AuthenticationEvent)->Unit,
    authenticate:()->Unit
) {

    // authenticate: ()->Unit

    val context= LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {

        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Login",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(50.dp))

        var text by rememberSaveable { mutableStateOf("Text") }

        val email = state.email
        val password = state.password

        TextField(
            value = email ?: "",
            onValueChange = {

                handleEvent(AuthenticationEvent.EmailChanged(it))
            },
            label = { Text("Email") },
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(6.dp))

        TextField(
            value = password?:"",
            onValueChange = {

                handleEvent(AuthenticationEvent.PasswordChanged(it))
            },
            label = { Text("Password") },
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            authenticate()

            if(state.authenticationMode==AuthenticationMode.SIGN_IN)
            {Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
                val intent = Intent(context, Home::class.java)
                context.startActivity(intent)
            }
            else
            {Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()}
        },
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        {
            Text(text = "Login")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstProjectTheme {
        LoginScreen(state = AuthenticationState(), handleEvent = { }, authenticate = { })
    }
}