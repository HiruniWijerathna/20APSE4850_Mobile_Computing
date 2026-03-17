package com.example.practical02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practical02.ui.theme.Practical02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practical02Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    CombinedGreeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        fontSize = 24.sp,
        modifier = modifier
    )
}

@Composable
fun CombinedGreeting(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Greeting("Android")
        Text(
            text = "Hello Student",
            fontSize = 20.sp
        )
        Text(
            text = "Welcome to Android",
            fontSize = 28.sp,
            color = Color.White,
            modifier = Modifier
                .background(Color.Red)
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CombinedGreetingPreview() {
    Practical02Theme {
        CombinedGreeting()
    }
}