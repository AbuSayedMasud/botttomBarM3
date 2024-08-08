package com.example.botttombarm3

import android.annotation.SuppressLint
import android.text.method.ArrowKeyMovementMethod
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeDetailScreen(
    onBack: () -> Unit,navController: NavHostController
) {
    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {

            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Home Detail Screen", style = MaterialTheme.typography.headlineMedium
            )
            Button(
                modifier = Modifier
                    .padding(top = 100.dp)
                    .align(Alignment.Center),

                onClick = {
navController.navigate("home")
                }
            ){
                Text( text = "Go Back",)
            }
        }
    }
}