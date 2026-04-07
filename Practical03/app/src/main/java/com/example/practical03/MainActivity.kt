package com.example.practical03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigationevent.compose.*
import androidx.compose.runtime.*
import androidx.navigationevent.compose.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.window.isPopupLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
//import com.example.practical2.ui.theme.Practical2Theme
import androidx.navigation.compose.composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "login") {

                composable("login") {
                    LoginScreen(
                        onLogin = {
                            navController.navigate("home") {
                                popUpTo("login") { inclusive = true }
                            }

                        },
                        onRegisterClick = {
                            navController.navigate("register") {}

                        }
                    )
                }
                composable("register") {
                    RegisterScreen(
                        onComplete = { navController.popBackStack() },

                        onLoginClick = {
                            navController.navigate("login") {}

                        }

                    )

                }
                composable("home") {
                    HomeScreen()
                }

            }
        }
    }
}
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFF2C3E50),
            unfocusedContainerColor = Color(0xFF2C3E50),
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            focusedLabelColor = Color.LightGray,
            unfocusedLabelColor = Color.Gray,
            cursorColor = Color.White
        )
    )
}
@Composable
fun LoginScreen(
    onLogin: () -> Unit,
    onRegisterClick: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1F2A38))
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Login" ,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White)

        Spacer(modifier = Modifier.height(32.dp))

        CustomTextField(
            value = email,
            onValueChange = { email = it },
            "Email"
      )

       Spacer(modifier = Modifier.size(16.dp))

        CustomTextField(
            value = password,
            onValueChange = { password = it },
           "Password"
        )

        Spacer(modifier = Modifier.size(16.dp))

        Button(onClick = onLogin,
               modifier = Modifier
                   .fillMaxWidth()
                   .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3A7BD5),
                contentColor = Color.White
            )) {
            Text("Login")
        }

        Spacer(modifier = Modifier.size(16.dp))

        TextButton(onClick = onRegisterClick,
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color(0xFF3A7BD5)
            )) {
            Text("Go to Register")
        }

    }
}


@Composable
fun RegisterScreen(
    onComplete: () -> Unit,
    onLoginClick: () -> Unit
){

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1F2A38))
            .padding(all = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Register" ,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White)

        Spacer(modifier = Modifier.size(16.dp))

        CustomTextField(
            value = name,
            onValueChange = { name = it },
            "name"
        )

        Spacer(modifier = Modifier.size(16.dp))

        CustomTextField(
            value = email,
            onValueChange = { email = it },
            "email"
        )

        Spacer(modifier = Modifier.size(16.dp))

        CustomTextField(
            value = password,
            onValueChange = { password = it },
            "Password"
        )

        Spacer(modifier = Modifier.size(16.dp))

        Button(onClick = onComplete,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3A7BD5),
                contentColor = Color.White
            )){
            Text("Register")
        }

        Spacer(modifier = Modifier.size(16.dp))

        TextButton(onClick = onLoginClick,
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color(0xFF3A7BD5)
            )) {
            Text("Go to Login")
        }
    }

}

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1F2A38)) // dark blue-gray background
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Welcome Hiruni 👋",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "You are successfully logged in!",
            fontSize = 16.sp,
            color = Color.LightGray
        )

        Spacer(modifier = Modifier.height(32.dp))

        Image(
            painter = painterResource(id = R.drawable.welcome_image),
            contentDescription = "Welcome Image",
            modifier = Modifier
                .size(170.dp)
                .padding(bottom = 24.dp),
            contentScale = ContentScale.Crop
        )


    }
}