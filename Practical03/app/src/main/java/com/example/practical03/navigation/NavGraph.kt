package com.example.practical03.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practical03.screen.*

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
fun NavGraph(){
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



