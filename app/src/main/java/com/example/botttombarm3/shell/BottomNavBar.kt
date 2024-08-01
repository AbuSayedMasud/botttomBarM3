package com.example.botttombarm3.shell

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination

@Composable
fun BottomNavBar(
    navController: NavController,
    currentSelectedScreen: RootScreen
) {
    NavigationBar {
        NavigationBarItem(
            selected = currentSelectedScreen == RootScreen.Home,
            onClick = { navController.navigateToRootScreen(RootScreen.Home) },
            alwaysShowLabel = true,
            label = {
                Text(text = "home")
            },
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Blue, // Change to desired color
                unselectedIconColor = Color.Gray, // Change to desired color
                indicatorColor = Color.Transparent
            ),
        )
        NavigationBarItem(
            selected = currentSelectedScreen == RootScreen.Search,
            onClick = { navController.navigateToRootScreen(RootScreen.Search) },
            alwaysShowLabel = true,
            label = {
                Text(text = "search")
            },
            icon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "search")
            }, colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Blue,
                unselectedIconColor = Color.Gray,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            alwaysShowLabel = false,
            label = {},
            icon = {
                // Empty icon or space
                Box(modifier = Modifier.size(56.dp)) // Adjust the size as needed
            }, enabled = false
        )
        NavigationBarItem(
            selected = currentSelectedScreen == RootScreen.Favorites,
            onClick = { navController.navigateToRootScreen(RootScreen.Favorites) },
            alwaysShowLabel = true,
            label = {
                Text(text = "favorites")
            },
            icon = {
                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "favo")
            }, colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Blue, // Change to desired color
                unselectedIconColor = Color.Gray,// Change to desired color
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            selected = currentSelectedScreen == RootScreen.Profile,
            onClick = { navController.navigateToRootScreen(RootScreen.Profile) },
            alwaysShowLabel = true,
            label = {
                Text(text = "profile")
            },
            icon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "person")
            }, colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Blue, // Change to desired color
                unselectedIconColor = Color.Gray,// Change to desired color
                indicatorColor = Color.Transparent
            )

        )
    }
}

@Stable
@Composable
fun NavController.currentScreenAsState(): State<RootScreen> {
    val selectedItem = remember { mutableStateOf<RootScreen>(RootScreen.Home) }
    DisposableEffect(key1 = this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            when {
                destination.hierarchy.any { it.route == RootScreen.Home.route } -> {
                    selectedItem.value = RootScreen.Home
                }

                destination.hierarchy.any { it.route == RootScreen.Search.route } -> {
                    selectedItem.value = RootScreen.Search
                }

                destination.hierarchy.any { it.route == RootScreen.Favorites.route } -> {
                    selectedItem.value = RootScreen.Favorites
                }

                destination.hierarchy.any { it.route == RootScreen.Profile.route } -> {
                    selectedItem.value = RootScreen.Profile
                }
            }

        }
        addOnDestinationChangedListener(listener)
        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }
    return selectedItem
}

@Stable
@Composable
fun NavController.currentRouteAsState(): State<String?> {
    val selectedItem = remember { mutableStateOf<String?>(null) }
    DisposableEffect(this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            selectedItem.value = destination.route
        }
        addOnDestinationChangedListener(listener)

        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }
    return selectedItem
}

fun NavController.navigateToRootScreen(rootScreen: RootScreen) {
    navigate(rootScreen.route) {
        launchSingleTop = true
        restoreState = true
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
    }
}
