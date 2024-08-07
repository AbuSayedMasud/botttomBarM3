package com.example.botttombarm3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.botttombarm3.shell.AppNavGraph
import com.example.botttombarm3.shell.BottomNavBar
import com.example.botttombarm3.shell.TopBar
import com.example.botttombarm3.shell.currentRouteAsState
import com.example.botttombarm3.shell.currentScreenAsState
import com.example.botttombarm3.ui.theme.BotttomBarM3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BotttomBarM3Theme {
                val navController = rememberNavController()
                val currentSelectedScreen by navController.currentScreenAsState()
                val currentRoute by navController.currentRouteAsState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar(navController = navController)},
                    floatingActionButton = {
                        Box() {
                            FloatingActionButton(
                                onClick = { /* stub */ },
                                shape = CircleShape,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(70.dp)
                                    .offset(y = 70.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.svg), // Replace with your image resource ID
                                    contentDescription = "Add",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop,
                                )
                            }
                        }
                    },
                    floatingActionButtonPosition = FabPosition.Center,
                    bottomBar = {

                        BottomNavBar(
                            navController = navController,
                            currentSelectedScreen = currentSelectedScreen
                        )
//            if (currentRoute == null || bottomNavRoutes.contains(currentRoute)) {
//
//            }
                    },


                    ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        AppNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BotttomBarM3Theme {
        Greeting("Android")
    }
}