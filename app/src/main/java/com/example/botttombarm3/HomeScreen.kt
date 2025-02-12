package com.example.botttombarm3

import android.annotation.SuppressLint
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    showDetail: () -> Unit
) {
    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Home Screen", style = MaterialTheme.typography.headlineMedium
            )
            Button(
                modifier = Modifier
                    .padding(top = 100.dp)
                    .align(Alignment.Center),
                onClick = {
                    showDetail()
                }
            ){
                Text(text = "go to details")
            }
        }
    }
}