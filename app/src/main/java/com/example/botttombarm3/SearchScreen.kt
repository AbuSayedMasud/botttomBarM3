package com.example.botttombarm3

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun SearchScreen(navController: NavHostController) {
    Text(text = "hello",Modifier.clickable { navController.navigate("book_reader") })
    
}